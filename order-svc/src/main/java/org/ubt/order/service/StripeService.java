package org.ubt.order.service;

import org.ubt.order.model.CheckoutPayment;

public interface StripeService {
    String paymentWithCheckoutPage(CheckoutPayment payment);
}
