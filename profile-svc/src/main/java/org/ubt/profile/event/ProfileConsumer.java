package org.ubt.profile.event;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.ubt.profile.service.RecommendationService;

@AllArgsConstructor
@Slf4j
@Component
public class ProfileConsumer {

    private RecommendationService recommendationService;

    @KafkaListener(topics="product-wishlist",groupId = "group-id-1")
    public void listen(ConsumerRecord<String,String> payload){
        log.info("Getting kafka message {} ", payload.value());

        // TODO here we need to deserialize this
//        recommendationService.acceptProducts(payload.value());
    }

}
