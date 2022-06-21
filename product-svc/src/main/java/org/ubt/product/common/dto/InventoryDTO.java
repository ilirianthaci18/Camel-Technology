package org.ubt.product.common.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTO {
    private int id;

    private int stockQuantity;

    private int triggerQuantity;

    private String stockType;

    private String inventoryDescription;

    private String inventoryType;

    private List<ProductDTOInventory> products;

    @JsonManagedReference
    public List<ProductDTOInventory> getProducts() {
        return products;
    }

}
