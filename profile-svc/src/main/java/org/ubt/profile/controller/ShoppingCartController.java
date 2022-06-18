package org.ubt.profile.controller;

import org.springframework.web.bind.annotation.*;
import org.ubt.profile.service.CartService;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/v1/cart")
public class ShoppingCartController {

    private CartService cartService;

    public ShoppingCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{productCode}")
    public void addProductToCart(@PathVariable String productCode) {
        cartService.addProductToCart(productCode);
    }

    @GetMapping("/products")
    public List listOfProducts(){
        return cartService.getCartProducts();
    }
}
