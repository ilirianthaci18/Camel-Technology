package org.ubt.order.service;

import io.github.dengliming.redismodule.redisjson.RedisJSON;
import io.github.dengliming.redismodule.redisjson.args.GetArgs;
import io.github.dengliming.redismodule.redisjson.args.SetArgs;
import io.github.dengliming.redismodule.redisjson.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ubt.order.common.dto.OrderExpiryTimeRedisDTO;
import org.ubt.order.event.OrderPublisher;
import org.ubt.order.model.CheckoutPayment;
import org.ubt.order.model.Order;

import java.time.LocalDateTime;
import java.util.List;

import static org.ubt.order.common.mappers.OrderMapper.toOrderForRedis;

@Slf4j
@Service
public class OrderTakingServiceImpl implements OrderTakingService {

    private OrderPublisher orderPublisher;
    private RedisJSON redisJSON;

    public OrderTakingServiceImpl(OrderPublisher orderPublisher, RedisJSON redisJSON) {
        this.orderPublisher = orderPublisher;
        this.redisJSON = redisJSON;
    }

    //TODO refactor
    @Override
    public void saveOrderToRedis(CheckoutPayment payment, String id) {
        //here accept new order
        //and make it set the order_id to the order.
        OrderExpiryTimeRedisDTO orderExpiryTimeRedisDTO=new OrderExpiryTimeRedisDTO(id,
                LocalDateTime.now(),LocalDateTime.now().plusMinutes(5),payment.getAmount(),"test",payment.getProductCode());

        log.info("Saving order to redis , order => {} ",orderExpiryTimeRedisDTO.toString());
        redisJSON.set(String.valueOf(orderExpiryTimeRedisDTO.getId()), SetArgs.Builder.create(".", GsonUtils.toJson(orderExpiryTimeRedisDTO)));
        sendProductCodesToProduct(orderExpiryTimeRedisDTO.getProductCode());
        log.info("Order with id {} , saved in REDIS ",orderExpiryTimeRedisDTO.getId());






//        OrderExpiryTimeRedisDTO orderExpiryTimeRedisDTO = toOrderForRedis(order);
//        log.info("Saving order to redis , order => {} ",orderExpiryTimeRedisDTO.toString());
//        redisJSON.set(String.valueOf(orderExpiryTimeRedisDTO.getCustomerEmail()),SetArgs.Builder.create(".",GsonUtils.toJson(orderExpiryTimeRedisDTO)));
//        log.info("Order with id {} , saved in REDIS ",orderExpiryTimeRedisDTO.getId());

//        OrderExpiryTimeRedisDTO orderExpiryTimeRedisDTO2=redisJSON.get(String.valueOf(order.getId()),OrderExpiryTimeRedisDTO.class,new GetArgs().path(".").indent("\t").newLine("\n").space(" "));
//        log.info("Getting order from redis with {} ",orderExpiryTimeRedisDTO2);

        //TODO need to fix the key of the order because the _order_id will go null when we first insert it , maybe email :s
        //TODO solve the problem for quantity.
    }

    @Override
    public void sendProductCodesToProduct(List<String> productCodes) {
        log.info(productCodes.toString());
        for(String str:productCodes){
            orderPublisher.publishMsg2(str);
        }
    }

}
