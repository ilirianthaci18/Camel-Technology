package org.ubt.profile.common.mappers;

import org.modelmapper.ModelMapper;
import org.ubt.profile.common.dto.WishListProductDTO;
import org.ubt.profile.model.ProductProfile;

public class ProductProfileMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static ProductProfile toProductProfile(WishListProductDTO wishListProductDTO){
        ProductProfile profile=modelMapper.map(wishListProductDTO,ProductProfile.class);

        profile.setProductImg(wishListProductDTO.getProductImg());
        profile.setName(wishListProductDTO.getName());
        profile.setPrice(wishListProductDTO.getPrice());
        profile.setProductCode(wishListProductDTO.getProductCode());

        return profile;
    }

    public static WishListProductDTO wishListProductDTO(ProductProfile profile){
        WishListProductDTO wishListProductDTO=modelMapper.map(profile,WishListProductDTO.class);

        wishListProductDTO.setProductImg(profile.getProductImg());
        wishListProductDTO.setName(profile.getName());
        wishListProductDTO.setPrice(profile.getPrice());
        wishListProductDTO.setProductCode(profile.getProductCode());

        return wishListProductDTO;
    }
}
