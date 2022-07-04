package org.ubt.order.service;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import io.github.dengliming.redismodule.redisjson.RedisJSON;
import io.github.dengliming.redismodule.redisjson.args.SetArgs;
import io.github.dengliming.redismodule.redisjson.utils.GsonUtils;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.ubt.order.common.dto.OrderExpiryTimeRedisDTO;
import org.ubt.order.model.CheckoutPayment;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Service
@Slf4j
public class StripeServiceImpl implements StripeService{

    private static Gson gson=new Gson();
    private RedisJSON redisJSON;
    private OrderTakingService orderTakingService;

    @SneakyThrows
    @Override
    public String paymentWithCheckoutPage(CheckoutPayment payment) {
        //here accept new order
        //and make it set the order_id to the order.
        Stripe.apiKey="sk_test_51LG794BowmVXS0dTPAbsZKN47mAGKcVOvo3fPkrp8semtVQykqO2NbJHkbuumpPKs8xuHq5CpEj5y2h2HvsFoMWJ00RNGD6tAU";
        SessionCreateParams params = SessionCreateParams.builder()
                // We will use the credit card payment method
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT).setSuccessUrl(payment.getSuccessUrl())
                .setCancelUrl(
                        payment.getCancelUrl())
                .addLineItem(
                        SessionCreateParams.LineItem.builder().setQuantity(payment.getQuantity())
                                .setPriceData(
                                        SessionCreateParams.LineItem.PriceData.builder()
                                                .setCurrency(payment.getCurrency()).setUnitAmount(payment.getAmount())
                                                .setProductData(SessionCreateParams.LineItem.PriceData.ProductData
                                                        .builder().setName(payment.getName()).build())
                                                .build())
                                .build())
                .build();
        // create a stripe session
        Session session = Session.create(params);
        Map<String, String> responseData = new HashMap<>();
        // We get the sessionId and we putted inside the response data you can get more info from the session object
        responseData.put("id", session.getId());
        //save this order to redis
        orderTakingService.saveOrderToRedis(payment,session.getId());
        // We can return only the sessionId as a String
        return gson.toJson(responseData);
    }

//    public void saveOrderToRedis(CheckoutPayment payment,String id){
//        //here accept new order
//        //and make it set the order_id to the order.
//        OrderExpiryTimeRedisDTO orderExpiryTimeRedisDTO=new OrderExpiryTimeRedisDTO(id,
//                LocalDateTime.now(),LocalDateTime.now().plusMinutes(5),payment.getAmount(),"test",payment.getProductCode());
//
//        log.info("Saving order to redis , order => {} ",orderExpiryTimeRedisDTO.toString());
//        redisJSON.set(String.valueOf(orderExpiryTimeRedisDTO.getId()), SetArgs.Builder.create(".", GsonUtils.toJson(orderExpiryTimeRedisDTO)));
//        log.info("Order with id {} , saved in REDIS ",orderExpiryTimeRedisDTO.getId());
//    }
}
