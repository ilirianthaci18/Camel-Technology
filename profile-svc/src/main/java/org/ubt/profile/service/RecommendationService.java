package org.ubt.profile.service;

import org.ubt.profile.common.dto.WishListProductDTO;

import java.util.List;

public interface RecommendationService {

    void findProductCodes(List<String> searches);

    void acceptProducts(WishListProductDTO wishListProductDTO);

    List<WishListProductDTO> getRecommendation(String email);
}
