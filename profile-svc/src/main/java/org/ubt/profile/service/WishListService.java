package org.ubt.profile.service;

import org.ubt.profile.common.dto.WishListProductDTO;
import org.ubt.profile.model.WishList;

import java.util.List;

public interface WishListService {
    void saveWishListForUser(List<String> productCode);

    List<WishListProductDTO> getWishListProducts();

    void saveProductsOfWishList(WishList wishList);
}
