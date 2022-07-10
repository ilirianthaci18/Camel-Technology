package org.ubt.product.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishListProductDTO {

    private String productImg;
    private String name;
    private double price;
    private String productCode;
}
