package org.ubt.profile.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ubt.clients.product.ProductClient;
import org.ubt.profile.common.dto.WishListProductDTO;
import org.ubt.profile.common.security.AuthUserService;
import org.ubt.profile.common.security.jwt.JwtProvider;
import org.ubt.profile.event.ProfilePublisher;
import org.ubt.profile.model.ProductProfile;
import org.ubt.profile.model.Recommendation;
import org.ubt.profile.repository.ProductRepositoryProfile;
import org.ubt.profile.repository.RecomendationRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static org.ubt.profile.common.mappers.ProductProfileMapper.toProductProfile;
import static org.ubt.profile.common.mappers.ProductProfileMapper.wishListProductDTO;

@AllArgsConstructor
@Service
@Slf4j
public class RecommendationServiceImpl implements RecommendationService{

    private RecomendationRepository repository;
    private ProductRepositoryProfile productRepo;
    private ProfilePublisher publisher;
    private AuthUserService authUserService;
    private final ProductClient productClient;

    @PostConstruct
    public void init() {
        ProductProfile productProfile1=new ProductProfile("assets/images/2.png","Iphone 13 Pro",1350.00,"IP13P");
        ProductProfile productProfile2=new ProductProfile("assets/images/1.png","Apple Watch Series 7",1200,"AW7");
        ProductProfile productProfile3=new ProductProfile("assets/images/6.png","iPhone12",799.99,"IP12");

        List<ProductProfile> products = new ArrayList<>();

        products.add(productProfile1);
        products.add(productProfile2);
        products.add(productProfile3);

//        Iterable<ProductProfile> products1 = productRepo.saveAll(products);
    }
    @PostConstruct
    public void initRecommendation(){
        List<String> productCodes=new ArrayList<>();
        productCodes.add("IP12");
        productCodes.add("AW7");
        productCodes.add("IP13P");
//        repository.save(new Recommendation("ilirianthaqi@live.com",productCodes));
    }

    @Override
    public void findProductCodes(List<String> searches) {
        String email = authUserService.getEmail();
        //here make an sync call to product-svc and accept the productCodes and save to recommendation
        List<String> productCodes=productClient.getProductCodes(searches);
        saveRepository(email,productCodes);
        //here send an async with kafka with these searches in product-svc
        publisher.publishMsg(searches);
        //filter the strings by keywords like product category , product names , brands
        //there create a query that returns every productCode that contains these keywords -> acceptMessageFromProfile()
        //here accept them in another method and save them in db
        //when user logs in make an sync call to product svc that will return only product img , code , price , name
        //and send them to frontend in ngOnInit()
    }

    @Override
    public void acceptProducts(WishListProductDTO wishListProductDTO){
        productRepo.save(toProductProfile(wishListProductDTO));
    }

    @Override
    public List<WishListProductDTO> getRecommendation(String email){
        Recommendation recommendation=repository.getRecommendationByEmail(email);
        List<WishListProductDTO> wishListProductDTOS=new ArrayList<>();

        recommendation.getProductCodes().stream().forEach( product -> {
            wishListProductDTOS.add(wishListProductDTO(productRepo.findProductsByProductCode(product)));
        });

        return wishListProductDTOS;
    }

    private void saveRepository(String email , List<String> productCode){
        repository.save(new Recommendation(email,productCode));
    }
}
