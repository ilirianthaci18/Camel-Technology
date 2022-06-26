package org.ubt.order.event;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.ubt.order.service.OrderService;

@AllArgsConstructor
@Slf4j
@Component
public class OrderConsumer {
    private OrderService orderService;

    @KafkaListener(topics="calculated-price",groupId = "group-id-1")
    public void listen(ConsumerRecord<String,String> payload){
        log.info("Getting kafka message {} ", payload.value());
        orderService.setCalculatedPrice(payload.value());
    }

}
