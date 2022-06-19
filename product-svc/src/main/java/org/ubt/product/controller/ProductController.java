package org.ubt.product.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ubt.clients.product.dto.CartProductDTO;
import org.ubt.product.common.dto.PaginatedResponse;
import org.ubt.product.common.dto.PaginationRequest;
import org.ubt.product.model.Product;
import org.ubt.product.service.ProductService;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProducts")
    public List<Product> products() throws InterruptedException {
        return productService.getProducts();
    }

    @GetMapping("/names")
    public List<String> productNames(){
        return productService.getProductNames();
    }

    @DeleteMapping("/{id}")
    public void removeProduct(@PathVariable Long id){
        productService.removeProduct(id);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PutMapping()
    public Product updateProduct(@RequestBody Product product){
        return productService.updateProduct(product);
    }

    @PostMapping("/pagination")
    public ResponseEntity<PaginatedResponse<Product>> getProducts(@RequestBody PaginationRequest paginationRequest){
        return ResponseEntity.ok(productService.paginatedProducts(paginationRequest));
    }

    @GetMapping("/getProductByCode/{productCode}")
    public CartProductDTO getProductByCode(@PathVariable String productCode){
        return productService.getProductByCode(productCode);
    }
}

