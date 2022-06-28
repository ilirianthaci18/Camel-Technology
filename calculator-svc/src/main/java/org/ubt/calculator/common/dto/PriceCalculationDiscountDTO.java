package org.ubt.calculator.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PriceCalculationDiscountDTO {
    private double orgPrice;
    private String couponCode;
    private double discountPerc;
}
