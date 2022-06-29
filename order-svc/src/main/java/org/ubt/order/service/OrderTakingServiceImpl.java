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
import org.ubt.order.model.Order;

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
    public void saveOrderToRedis(Order order) {
        OrderExpiryTimeRedisDTO orderExpiryTimeRedisDTO = toOrderForRedis(order);
        sendProductCodesToProduct(orderExpiryTimeRedisDTO.getProductCode());
        log.info("Saving order to redis , order => {} ",orderExpiryTimeRedisDTO.toString());
        redisJSON.set(String.valueOf(orderExpiryTimeRedisDTO.getCustomerEmail()),SetArgs.Builder.create(".",GsonUtils.toJson(orderExpiryTimeRedisDTO)));
        log.info("Order with id {} , saved in REDIS ",orderExpiryTimeRedisDTO.getId());

//        OrderExpiryTimeRedisDTO orderExpiryTimeRedisDTO2=redisJSON.get(String.valueOf(order.getId()),OrderExpiryTimeRedisDTO.class,new GetArgs().path(".").indent("\t").newLine("\n").space(" "));
//        log.info("Getting order from redis with {} ",orderExpiryTimeRedisDTO2);

        //TODO need to fix the key of the order because the _order_id will go null when we first insert it , maybe email :s

    }

    @Override
    public void sendProductCodesToProduct(List<String> productCodes) {
        log.info(productCodes.toString());
        for(String str:productCodes){
            orderPublisher.publishMsg2(str);
        }
    }

}
