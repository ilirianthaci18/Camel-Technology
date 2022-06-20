package org.ubt.product.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ubt.product.model.Inventory;
import org.ubt.product.model.Product;
import org.ubt.product.repository.InventoryRepository;

@Service
@Slf4j
@AllArgsConstructor
public class InventoryServiceImpl implements InventoryService{

    private InventoryRepository inventoryRepository;
    private ProductService productService;

    @Override
    public void updateInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    @Override
    public void addQuantityInProduct(String productCode, Integer quantity) {
        productService.addQuantityInProduct(productCode,quantity);
    }

    @Override
    public void addProduct(Product product) {
        Product productFromRepo= productService.getProductFromCode(product.getCode());
        if(productFromRepo == null){
            productService.saveProduct(product);
        }

        productService.addQuantityInProduct(product.getCode(),1);
    }

    @Override
    public void removeProductQuantity(String productCode, Integer quantity) {
        productService.removeProductQuantity(productCode,quantity);
    }

    @Override
    public boolean checkQuantityProduct(String productCode, Integer quantity) {
        return productService.checkQuantityProduct(productCode,quantity);
    }
}
