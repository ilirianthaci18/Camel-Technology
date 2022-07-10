package org.ubt.product.service;

import org.ubt.clients.product.dto.CartProductDTO;
import org.ubt.product.common.dto.PaginatedResponse;
import org.ubt.product.common.dto.PaginationRequest;
import org.ubt.product.model.Brand;
import org.ubt.product.model.OrderTaking;
import org.ubt.product.model.Product;
import org.ubt.product.model.WareHouse;

import java.util.List;

public interface ProductService {
    void receiveMessage(Object obj);

    void removeQuantityWhileOrdering(String productCode);

    List<Product> getProducts() throws InterruptedException;

    void saveProduct(Product product);

    void removeProduct(Long id);

    Product updateProduct(Product product);

    Product getProductById(Long id);

    CartProductDTO getProductByCode(String productCode);

    List<String> getProductNames();

    void removeProductQuantity(String productCode, Integer quantity);

    boolean checkQuantityProduct(String productCode, Integer quantity);

    void addQuantityInProduct(String productCode, Integer quantity);

    Product getProductFromCode(String productCode);

    PaginatedResponse<Product> paginatedProducts(PaginationRequest paginationRequest);

    void addProductToWareHouse(int wareHouseId, Long productId);

    WareHouse getWareHouseById(int id);

    void saveWareHouse(WareHouse wareHouse);

    void addProductToBrand(int brandId, Long productId);

    Brand getBrandById(int id);

    void saveBrand(Brand brand);

    void addProductToOrderTaking(int orderTakingId, Long productId);

    OrderTaking getOrderTakingById(int id);

    void saveOrderTaking(OrderTaking brand);

    void acceptMessageFromProfile(String msg);

    List<String> findProductBySearch(List<String> msg);
}
