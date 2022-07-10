package org.ubt.profile.service;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ubt.profile.common.dto.WishListProductDTO;
import org.ubt.profile.common.security.AuthUserService;
import org.ubt.profile.event.ProfilePublisher;
import org.ubt.profile.model.WishList;
import org.ubt.profile.repository.ProductRepositoryProfile;
import org.ubt.profile.repository.WishListRepository;

import java.util.ArrayList;
import java.util.List;

import static org.ubt.profile.common.mappers.ProductProfileMapper.wishListProductDTO;

@AllArgsConstructor
@Slf4j
@Service
public class WishListServiceImpl implements WishListService{

    private WishListRepository wishListRepository;
    private AuthUserService authUserService;
    private ProductRepositoryProfile productRepo;
    private ProfilePublisher publisher;

    //TODO refactor the reusable part

    @Override
    public void saveWishListForUser(List<String> productCode) {
        //we will send this at the end of the flow , when the user logs out
        String email=authUserService.getEmail();
        if(email.equals("") || email!=null){
            WishList wishList = wishListRepository.getWishListByUserId(email);
            if(wishList !=null){
                List<String> prodcodes= wishList.getDetails();
                prodcodes.forEach(code -> prodcodes.add(code) );
                wishList.setDetails(prodcodes);
                wishListRepository.save(wishList);
            }
            wishListRepository.save(new WishList(productCode,email));
        }
    }

    @SneakyThrows
    @Override
    public List<WishListProductDTO> getWishListProducts() {
        String email=authUserService.getEmail();
        if(email.equals("") || email!=null){
            WishList wishList=wishListRepository.getWishListByUserId(email);
            if(wishList !=null){
                //this needs to wait so we use feign to call this .
                //this will return a list of WishListProductDTO -> contains product img , name , price
                //this needs to be save to repo
                //then request from repo to return them
                saveProductsOfWishList(wishList);
                Thread.sleep(1000);

                List<WishListProductDTO> wishListProductDTOS=new ArrayList<>();
                wishList.getDetails().forEach(product -> wishListProductDTOS.add(wishListProductDTO(productRepo.findProductsByProductCode(product))));

                return wishListProductDTOS;
            }
        }
        return null;
    }

    @Override
    public void saveProductsOfWishList(WishList wishList){
        publisher.publishMsg(wishList.getDetails());
    }

}
