package org.ubt.order.service;

import org.ubt.order.common.enums.OrderStatus;
import org.ubt.order.model.Order;
import org.ubt.order.model.OrderStatusDTO;

import java.util.List;

public interface OrderService {
    void calculateTotalPrice(Order order);
    double checkCoupon(String code) throws Exception;
    int countOrders();
    void setCalculatedPrice(String finalPrice);
    List<Order> getCompletedOrder();
    void updateShippingStatus(Order order, OrderStatus orderStatus);

    void updateOrder(OrderStatusDTO orderStatusDTO);
}
