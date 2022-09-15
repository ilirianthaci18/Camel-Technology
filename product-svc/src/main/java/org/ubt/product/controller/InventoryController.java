package org.ubt.product.controller;

import org.springframework.web.bind.annotation.*;
import org.ubt.product.model.Inventory;
import org.ubt.product.model.Product;
import org.ubt.product.service.InventoryService;

import java.util.List;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {
    //create CRUD
    //create counting products based on category , on types , on names , on  brands .

    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/getInventories")
    public List<Inventory> inventories() throws InterruptedException {
        return inventoryService.getInventories();
    }

    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id);
    }

    @PutMapping()
    public Inventory updateInventory(@RequestBody Inventory inventory) {
        return inventoryService.updateInventory(inventory);
    }

    @PostMapping("/{inventoryId}/product/{productId}")
    public void addProductToInventory(@PathVariable Long inventoryId, @PathVariable Long productId) {
        inventoryService.addProductToInventory(inventoryId, productId);
    }
}
