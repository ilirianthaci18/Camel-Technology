package org.ubt.order.event;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;
import org.ubt.order.common.dto.OrderEmailDTO;
import org.ubt.order.common.dto.PriceCalculationDiscountDTO;
import org.ubt.order.model.Order;

@Slf4j
@Component
public class OrderPublisher {
    //TODO refactor TOPIC names and methods
    private static final String TOPIC="price-coupon";

    private static final String TOPIC2="product-codes";

    private static final String TOPIC3="order-email";

    private Publisher publisher;

    public OrderPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void publishMsg(PriceCalculationDiscountDTO msg){
        log.info("Producing msg with topic {} and msg {} ",TOPIC,msg);

        this.publisher.publishEvent(new ProducerRecord<>(TOPIC,msg));
    }

    public void publishMsg2(String msg){
        log.info("Producing msg with topic {} and msg {} ",TOPIC2,msg);
        this.publisher.publishEvent(new ProducerRecord<>(TOPIC2,msg));
    }

    public void publishOrderToEmail(OrderEmailDTO order){
        log.info("Producing msg with topic {} and msg {} ",TOPIC3,order);
        this.publisher.publishEvent(new ProducerRecord<>(TOPIC3,order));
    }
}
