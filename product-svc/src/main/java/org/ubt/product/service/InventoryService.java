package org.ubt.product.service;

import org.ubt.product.model.Inventory;
import org.ubt.product.model.Product;

import java.util.List;

public interface InventoryService {
    List<Inventory> getInventories() throws InterruptedException;

    Inventory getInventoryById(Long id);

    Inventory saveInventory(Inventory inventory);

    Inventory updateInventory(Inventory inventory);

    void addQuantityInProduct(String productCode, Integer quantity);

    void addProduct(Product product);

    void removeProductQuantity(String productCode, Integer quantity);

    boolean checkQuantityProduct(String productCode, Integer quantity);

    void addProductToInventory(Long inventoryId, Long productId);
}
