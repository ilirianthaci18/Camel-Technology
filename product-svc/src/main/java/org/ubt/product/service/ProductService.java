package org.ubt.product.service;

import org.ubt.clients.product.dto.CartProductDTO;
import org.ubt.product.common.dto.PaginatedResponse;
import org.ubt.product.common.dto.PaginationRequest;
import org.ubt.product.model.Product;

import java.util.List;

public interface ProductService {
    void receiveMessage(Object obj);
    List<Product> getProducts() throws InterruptedException;
    void saveProduct(Product product);
    void removeProduct(Long id);
    Product updateProduct(Product product);
    Product getProductById(Long id);
    CartProductDTO getProductByCode(String productCode);
    List<String> getProductNames();
    void removeProductQuantity(String productCode, Integer quantity);
    boolean checkQuantityProduct(String productCode, Integer quantity);
    void addQuantityInProduct(String productCode ,Integer quantity);
    Product getProductFromCode(String productCode);
    PaginatedResponse<Product> paginatedProducts(PaginationRequest paginationRequest);
}
