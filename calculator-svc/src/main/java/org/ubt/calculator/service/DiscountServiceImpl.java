package org.ubt.calculator.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.ubt.calculator.common.dto.PriceCalculationDiscountDTO;
import org.ubt.calculator.event.CalculatorPublisher;

@AllArgsConstructor
@Service
public class DiscountServiceImpl implements DiscountService{

    private CalculatorPublisher calculatorPublisher;

    public void calculatePrice(PriceCalculationDiscountDTO priceDiscountDTO){
        Double totalPrice = priceDiscountDTO.getOrgPrice() - (priceDiscountDTO.getOrgPrice() * priceDiscountDTO.getDiscountPerc() / 100);

        calculatorPublisher.publishCalculatedPrice(Double.toString(totalPrice));
    }
}
