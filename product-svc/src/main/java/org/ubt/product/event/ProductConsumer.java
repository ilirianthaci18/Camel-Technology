package org.ubt.product.event;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.ubt.product.service.ProductService;

@AllArgsConstructor
@Slf4j
@Component
public class ProductConsumer {
    private ProductService productService;

    @KafkaListener(topics="rate-exchange",groupId = "group-id-1")
    public void listen(ConsumerRecord<String,Object> payload){
        log.info("Getting kafka message \n",payload.value());
        productService.receiveMessage(payload.value());
    }
}
