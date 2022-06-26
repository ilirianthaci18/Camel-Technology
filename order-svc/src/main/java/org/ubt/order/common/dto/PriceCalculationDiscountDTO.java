package org.ubt.order.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceCalculationDiscountDTO {
    private double orgPrice;
    private String couponCode;
    private double discountPerc;
}
