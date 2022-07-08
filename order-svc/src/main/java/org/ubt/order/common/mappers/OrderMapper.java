package org.ubt.order.common.mappers;


import org.modelmapper.ModelMapper;
import org.ubt.order.common.dto.OrderEmailDTO;
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

    public static OrderEmailDTO toOrderEmailDTO(Order order){
        OrderEmailDTO orderEmailDTO=modelMapper.map(order,OrderEmailDTO.class);

        orderEmailDTO.setEmail(order.getCustomerEmail());
        orderEmailDTO.setShip_to(order.getShip_to());
        orderEmailDTO.setOrderStatus(order.getStatus().toString());
        orderEmailDTO.setTotalPrice(order.getTotalPrice());
        orderEmailDTO.setOrdered(order.getOrdered());
        orderEmailDTO.setShipped(order.getShipped());

        return orderEmailDTO;
    }
}
