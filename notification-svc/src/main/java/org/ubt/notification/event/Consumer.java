package org.ubt.notification.event;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.ubt.notification.config.NotificationClient;
import org.ubt.notification.service.FirebaseService;

@AllArgsConstructor
@Component
@Slf4j
public class Consumer {

    private FirebaseService firebaseService;

    @KafkaListener(topics = "notification",groupId = "group-id-1")
    public void listen(ConsumerRecord<String,Object> payload){
        log.info("Getting kafka message {} ",payload.value());

       firebaseService.sendNotificationToTarget(payload.value());
    }
}
