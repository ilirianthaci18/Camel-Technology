package org.ubt.product.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.ubt.clients.product.dto.CartProductDTO;
import org.ubt.product.common.dto.PaginatedResponse;
import org.ubt.product.common.dto.PaginationRequest;
import org.ubt.product.common.mappers.PaginationMapper;
import org.ubt.product.model.Product;
import org.ubt.product.repository.ProductRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.ubt.product.common.mappers.ProductMapper.toCartProductDTO;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private PaginationMapper paginationMapper;

    public ProductServiceImpl(ProductRepository productRepository, PaginationMapper paginationMapper) {
        this.productRepository = productRepository;
        this.paginationMapper = paginationMapper;
    }

    @PostConstruct
    public void init() {
            Product iphone = new Product("Iphone 13 Pro","IP13P","Newest iPhone is now live with us",
                    "New Brand Iphone","Battery","assets/images/2.png",5,LocalDateTime.now(),true,true, 1350.00,12,"Mobiles","Sierra Blue",2.53,203,5.78,1.7,true,4.5,1);

            Product samsung = new Product("Samsung S22 Ultra","SMS22U","Newest product of Samsung","New Brand","batterytest","assets/images/3.png",5,
                    LocalDateTime.now(),true,true,1200,
                    15,"Mobiles","White",2.53,200,5.83,2.4,true,4.4,1);

        Product watch = new Product("Apple Watch Series 7","AW7","Newest product of apple watches","New Brand","800MAH","assets/images/1.png",5,
                LocalDateTime.now(),true,true,1200,
                15,"Mobiles","White",2.53,200,5.83,2.4,true,4.4,7);

        Product iphone13 = new Product("iPhone13","IP13","Newest product of mobile phones from apple","New Brand","2800MAH","assets/images/4.png",5,
                LocalDateTime.now(),true,false,999.99,
                10,"Mobiles","White",2.53,200,5.83,2.4,true,4.4,10);

        Product iphone12 = new Product("iPhone12","IP12","Newest product of mobile phones from apple","New Brand","1800MAH","assets/images/6.png",5,
                LocalDateTime.now(),true,false,799.99,
                10,"Mobiles","White",2.53,200,5.83,2.4,true,4.4,9);

        Product galaxyTab = new Product("Galaxy Tab A8","IP13","Newest product of mobile phones from Samsung","New Brand","2800MAH","assets/images/12.png",5,
                LocalDateTime.now(),true,false,999.99,
                10,"Mobiles","White",2.53,200,5.83,2.4,true,4.4,5);

        Product mouse = new Product("Gaming Mouse","GM1","Newest product of gaming accessories","New Brand","280MAH","assets/images/15.png",5,
                LocalDateTime.now(),true,false,99.99,
                10,"Gaming","Black",2.53,200,5.83,2.4,true,4.4,5);

        Product iphone11 = new Product("Iphone11","IP11","Newest product of apple","New Brand","280MAH","assets/images/6.png",5,
                LocalDateTime.now(),true,false,99.99,
                10,"Mobiles","Blue",2.53,200,5.83,2.4,true,4.4,5);


        List<Product> products = new ArrayList<>();

        products.add(iphone);
        products.add(samsung);
        products.add(watch);
        products.add(iphone13);
        products.add(iphone12);
        products.add(galaxyTab);
        products.add(mouse);
        products.add(iphone11);


//        Iterable<Product> products1 = productRepository.saveAll(products);
    }

    @Cacheable(key="products",value = "Product")
    public List<Product> getProducts() throws InterruptedException {
        log.info("Calling service to get Products data...");
        log.debug("This is debug Calling service to get Products data...");
        return productRepository.findAll();
    }

    @Override
    @CacheEvict(key="products",value = "Product")
    public void removeProduct(Long id) {
        log.info("Removing product with id "+ id);
        productRepository.delete(productRepository.getById(id));
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        log.info("Updating product with id "+ product.getId());
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        log.info("Getting product with id "+ id);
        return productRepository.getById(id);
    }

    @Override
    public CartProductDTO getProductByCode(String productCode) {
        return toCartProductDTO(productRepository.findProductByCode(productCode));
    }

    @Override
    public List<String> getProductNames() {
        return productRepository.productName();
    }

    @Override
    public void removeProductQuantity(String productCode, Integer quantity) {
        Product product=getProductFromCode(productCode);
//        Integer quantityOfProduct = product.getQuantity();

        product.setQuantity(product.getQuantity()-quantity);
        saveProduct(product);
    }

    @Override
    public boolean checkQuantityProduct(String productCode, Integer quantity) {
        Product product=getProductFromCode(productCode);

        return product.getQuantity() >= quantity;
    }

    @Override
    public void addQuantityInProduct(String productCode, Integer quantity) {
        Product product=getProductFromCode(productCode);
        product.setQuantity(product.getQuantity()+quantity);

        saveProduct(product);
    }

    @Override
    public PaginatedResponse<Product> paginatedProducts(PaginationRequest paginationRequest) {
        Page result=productRepository.findAll(paginationMapper.toPageRequest(paginationRequest));

        return paginationMapper.toPaginatedResponse(result);
    }

    @Override
    public Product getProductFromCode(String productCode){
        return productRepository.findProductByCode(productCode);
    }
}