package org.ubt.product.service;

import org.ubt.clients.product.dto.CartProductDTO;
import org.ubt.product.common.dto.PaginatedResponse;
import org.ubt.product.common.dto.PaginationRequest;
import org.ubt.product.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts() throws InterruptedException;
    void removeProduct(Long id);
    Product updateProduct(Product product);
    Product getProductById(Long id);
    CartProductDTO getProductByCode(String productCode);
    List<String> getProductNames();
    PaginatedResponse<Product> paginatedProducts(PaginationRequest paginationRequest);
}
