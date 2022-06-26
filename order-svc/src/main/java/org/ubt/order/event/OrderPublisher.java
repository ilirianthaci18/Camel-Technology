package org.ubt.order.event;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;
import org.ubt.order.common.dto.PriceCalculationDiscountDTO;

@Slf4j
@Component
public class OrderPublisher {
    private static final String TOPIC="price-coupon";

    private Publisher publisher;

    public OrderPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void publishMsg(PriceCalculationDiscountDTO msg){
        log.info("Producing msg with topic {} and msg {} ",TOPIC,msg);

        this.publisher.publishEvent(new ProducerRecord<>(TOPIC,msg));
    }
}
