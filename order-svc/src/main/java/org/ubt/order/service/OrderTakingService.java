package org.ubt.order.service;

import org.ubt.order.model.CheckoutPayment;
import org.ubt.order.model.Order;

import java.util.List;

public interface OrderTakingService {

    void saveOrderToRedis(CheckoutPayment payment, String id);
    void sendProductCodesToProduct(List<String> productCodes);
}
