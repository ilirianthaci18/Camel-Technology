package org.ubt.product.common.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDTOProduct {
    private int stockQuantity;

    private int triggerQuantity;

    private String stockType;

    private String inventoryDescription;

    private String inventoryType;
}
