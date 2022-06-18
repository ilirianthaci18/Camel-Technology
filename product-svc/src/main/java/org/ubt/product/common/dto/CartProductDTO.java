package org.ubt.product.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartProductDTO {
    private String code;
    private String mainImage;
    private String name;
    private double price;
}
