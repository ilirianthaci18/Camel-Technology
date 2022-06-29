package org.ubt.order.common.mappers;


import org.modelmapper.ModelMapper;
import org.ubt.order.common.dto.OrderExpiryTimeRedisDTO;
import org.ubt.order.model.Order;

public class OrderMapper {
    private static ModelMapper modelMapper = new ModelMapper();

    public static OrderExpiryTimeRedisDTO toOrderForRedis(Order order) {
        OrderExpiryTimeRedisDTO orderExpiryTimeRedisDTO = modelMapper.map(order, OrderExpiryTimeRedisDTO.class);

//        orderExpiryTimeRedisDTO.setId(order.getId());
        orderExpiryTimeRedisDTO.setOrdered(order.getOrdered());
        orderExpiryTimeRedisDTO.setCustomerEmail(order.getCustomerEmail());
        orderExpiryTimeRedisDTO.setExpiryTimeOrder(order.getOrdered().plusMinutes(5));
        orderExpiryTimeRedisDTO.setTotalPrice(order.getTotalPrice());
        orderExpiryTimeRedisDTO.setProductCode(order.getProductCode());

        return orderExpiryTimeRedisDTO;
    }
}
