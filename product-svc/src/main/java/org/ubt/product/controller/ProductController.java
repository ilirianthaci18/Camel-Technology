package org.ubt.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ubt.product.model.Product;
import org.ubt.product.service.ProductService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping("api/v1/product")
@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Product> products() throws InterruptedException {
        return productService.getProducts();
    }
}
