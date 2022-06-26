package org.ubt.calculator.service;

import org.ubt.calculator.common.dto.PriceCalculationDiscountDTO;

public interface DiscountService {
    void calculatePrice(PriceCalculationDiscountDTO priceDiscountDTO);
}
