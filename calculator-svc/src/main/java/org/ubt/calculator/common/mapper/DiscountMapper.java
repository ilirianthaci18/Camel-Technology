package org.ubt.calculator.common.mapper;

import org.modelmapper.ModelMapper;
import org.ubt.calculator.common.dto.PriceCalculationDiscountDTO;

public class DiscountMapper {
    private static ModelMapper modelMapper=new ModelMapper();

    public static PriceCalculationDiscountDTO discountPriceDto(Object priceCalculationDiscountDTO){
        return modelMapper.map(priceCalculationDiscountDTO, PriceCalculationDiscountDTO.class);
    }
}
