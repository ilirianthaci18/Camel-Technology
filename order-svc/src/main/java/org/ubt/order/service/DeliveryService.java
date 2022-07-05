package org.ubt.order.service;

import org.ubt.order.model.Delivery;
import org.ubt.order.model.Order;

public interface DeliveryService {
    void acceptDelivery(Order order);
    void addDeliveryToLogistics(Delivery delivery);
    void addDeliveryToCourier(Delivery delivery);
}
