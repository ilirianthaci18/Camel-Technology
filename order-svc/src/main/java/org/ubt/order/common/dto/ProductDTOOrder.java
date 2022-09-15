package org.ubt.order.common.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTOOrder {
    private String productCode;

    private double price;
}
