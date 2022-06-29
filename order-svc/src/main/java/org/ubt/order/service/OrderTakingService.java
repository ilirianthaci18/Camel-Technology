package org.ubt.order.service;

import org.ubt.order.model.Order;

import java.util.List;

public interface OrderTakingService {

    void saveOrderToRedis(Order order);
    void sendProductCodesToProduct(List<String> productCodes);
}
