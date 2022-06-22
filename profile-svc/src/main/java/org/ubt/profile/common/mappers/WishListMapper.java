package org.ubt.profile.common.mappers;

import org.modelmapper.ModelMapper;
import org.ubt.profile.common.dto.WishListDTO;
import org.ubt.profile.common.dto.WishListDTOUser;
import org.ubt.profile.model.WishList;

import static org.ubt.profile.common.mappers.UserMapper.toUserDTOWishList;

public class WishListMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static WishListDTO toWishListDTO(WishList wishList) {
        WishListDTO wishListDTO = modelMapper.map(wishList, WishListDTO.class);

        wishListDTO.setId(wishList.getId());
        wishListDTO.setValueOfWishList(wishList.getValueOfWishList());
        wishListDTO.setDetails(wishList.getDetails());
        wishListDTO.setUser(toUserDTOWishList(wishList.getUser()));

        return wishListDTO;
    }

    public static WishListDTOUser toWishListDTOUser(WishList wishList) {
        WishListDTOUser wishListDTOUser = modelMapper.map(wishList, WishListDTOUser.class);

        wishListDTOUser.setValueOfWishList(wishList.getValueOfWishList());
        wishListDTOUser.setDetails(wishList.getDetails());

        return wishListDTOUser;
    }


}
