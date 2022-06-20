package org.ubt.product.service;

import org.ubt.product.model.Inventory;
import org.ubt.product.model.Product;

public interface InventoryService {
    void updateInventory(Inventory inventory);
    void addQuantityInProduct(String productCode ,Integer quantity);
    void addProduct(Product product);
    void removeProductQuantity(String productCode, Integer quantity);
    boolean checkQuantityProduct(String productCode, Integer quantity);
}
