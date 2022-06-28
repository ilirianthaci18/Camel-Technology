package org.ubt.order.common.converter;

import org.ubt.order.common.enums.OrderStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class OrderStatusEnumAttributeConverter implements AttributeConverter<OrderStatus,String> {

    @Override
    public String convertToDatabaseColumn(OrderStatus orderStatus) {
        return orderStatus.getValue();
    }

    @Override
    public OrderStatus convertToEntityAttribute(String s) {
        return OrderStatus.fromString(s);
    }
}
