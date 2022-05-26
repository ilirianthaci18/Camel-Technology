package org.ubt.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ubt.product.model.Product;
import org.ubt.product.service.ProductService;

import java.util.List;


//@RequestMapping("/api/v1/product")
@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProducts")
    public List<Product> products() throws InterruptedException {
        return productService.getProducts();
    }
}
