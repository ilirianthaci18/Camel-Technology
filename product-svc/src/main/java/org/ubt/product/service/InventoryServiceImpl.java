package org.ubt.product.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.ubt.product.exception.NotFoundException;
import org.ubt.product.model.Inventory;
import org.ubt.product.model.Product;
import org.ubt.product.repository.InventoryRepository;
import org.ubt.product.repository.ProductRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private InventoryRepository inventoryRepository;
    private ProductService productService;
    private ProductRepository productRepository;

    @Override
    public Inventory updateInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void addQuantityInProduct(String productCode, Integer quantity) {
        productService.addQuantityInProduct(productCode, quantity);
    }

    @Override
    public void addProduct(Product product) {
        Product productFromRepo = productService.getProductFromCode(product.getCode());
        if (productFromRepo == null) {
            productService.saveProduct(product);
        }

        productService.addQuantityInProduct(product.getCode(), 1);
    }

    @Override
    public void removeProductQuantity(String productCode, Integer quantity) {
        productService.removeProductQuantity(productCode, quantity);
    }

    @Override
    public boolean checkQuantityProduct(String productCode, Integer quantity) {
        return productService.checkQuantityProduct(productCode, quantity);
    }

    @Cacheable(key = "inventories", value = "Inventory")
    public List<Inventory> getInventories() throws InterruptedException {
        log.info("Calling service to get Inventories data...");
        log.debug("This is debug Calling service to get Inventories data...");
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory getInventoryById(Long id) {
        return inventoryRepository.findById(id).orElseThrow(() -> {
            log.error("Inventory could not be found , id : ", id);
            return new NotFoundException("Inventory with id " + id + "not found");
        });
    }

    @Override
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public void addProductToInventory(Long inventoryId, Long productId) {
        Inventory inventory = getInventoryById(inventoryId);
        Product product = productRepository.findById(productId).orElseThrow(() -> {
            log.error("Product could not be found , id : ", productId);
            return new NotFoundException("Product with id " + productId + "not found");
        });

        inventory.addProduct(product);

        saveInventory(inventory);

        log.info("Inventory has a product ", inventory, product);

    }
}
