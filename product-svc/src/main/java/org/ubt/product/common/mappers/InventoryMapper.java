package org.ubt.product.common.mappers;

import org.modelmapper.ModelMapper;
import org.ubt.product.common.dto.InventoryDTO;
import org.ubt.product.common.dto.InventoryDTOProduct;
import org.ubt.product.model.Inventory;

import static org.ubt.product.common.mappers.ProductMapper.toProductDTOInventory;

public class InventoryMapper {

    private static ModelMapper modelMapper = new ModelMapper();

    public static InventoryDTO toInventoryDTO(Inventory inventory) {
        InventoryDTO inventoryDTO = modelMapper.map(inventory, InventoryDTO.class);

        inventoryDTO.setInventoryType(inventory.getInventoryType());
        inventoryDTO.setId(inventory.getId());
        inventoryDTO.setInventoryDescription(inventory.getInventoryDescription());
        inventoryDTO.setStockQuantity(inventory.getStockQuantity());
        inventoryDTO.setStockType(inventory.getStockType());
        inventoryDTO.setTriggerQuantity(inventory.getTriggerQuantity());

        inventory.getProductList().stream().forEach(product -> {
            inventoryDTO.getProducts().add(toProductDTOInventory(product));
        });

        return inventoryDTO;
    }

    public static InventoryDTOProduct toInventoryDTOProduct(Inventory inventory) {
        InventoryDTOProduct inventoryDTOProduct = modelMapper.map(inventory, InventoryDTOProduct.class);

        inventoryDTOProduct.setInventoryDescription(inventory.getInventoryDescription());
        inventoryDTOProduct.setInventoryType(inventory.getInventoryType());
        inventoryDTOProduct.setStockQuantity(inventory.getStockQuantity());
        inventoryDTOProduct.setTriggerQuantity(inventory.getTriggerQuantity());
        inventoryDTOProduct.setStockType(inventory.getStockType());

        return inventoryDTOProduct;
    }
}
