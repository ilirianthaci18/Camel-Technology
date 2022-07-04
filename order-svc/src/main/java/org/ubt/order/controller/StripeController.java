package org.ubt.order.controller;

import com.google.gson.Gson;
import com.stripe.Stripe;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.ubt.order.model.CheckoutPayment;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.ubt.order.service.StripeService;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@AllArgsConstructor
@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api")
public class StripeController {

    private StripeService stripeService;

    @SneakyThrows
    @PostMapping("/payment")
    /**
     * Payment with Stripe checkout page
     *
     * @throws StripeException
     */
    public String paymentWithCheckoutPage(@RequestBody CheckoutPayment payment){
        return stripeService.paymentWithCheckoutPage(payment);
    }
}
