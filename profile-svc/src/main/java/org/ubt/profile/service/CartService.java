package org.ubt.profile.service;

import org.ubt.clients.product.dto.CartProductDTO;

import java.util.List;

public interface CartService {
    void addProductToCart(String productCode);
    List<CartProductDTO> saveProductToCart(CartProductDTO cartProductDTO);
    List<CartProductDTO> getCartProducts();
}
