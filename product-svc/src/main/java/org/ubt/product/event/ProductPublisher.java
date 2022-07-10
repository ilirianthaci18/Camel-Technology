package org.ubt.product.event;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;
import org.ubt.product.common.dto.WishListProductDTO;

import java.util.List;

@Slf4j
@Component
public class ProductPublisher {
    //TODO refactor TOPIC names and methods
    private static final String TOPIC="product-wishlist";

    private Publisher publisher;

    public ProductPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void publishMsg(WishListProductDTO msg){
        log.info("Producing msg with topic {} and msg {} ",TOPIC,msg);
        this.publisher.publishEvent(new ProducerRecord<>(TOPIC,msg));
    }
}
