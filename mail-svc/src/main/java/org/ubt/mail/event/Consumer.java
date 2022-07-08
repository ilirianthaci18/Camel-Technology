package org.ubt.mail.event;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;
import org.ubt.mail.common.dto.OrderEmailDTO;
import org.ubt.mail.service.EmailService;

@AllArgsConstructor
@Component
@Slf4j
public class Consumer {

    private EmailService emailService;

    @KafkaListener(topics = "order-email",groupId = "group-id-1")
    public void listen(ConsumerRecord<String,Object> payload){
        log.info("Getting kafka message {} ",payload.value());
        OrderEmailDTO orderEmailDTO=payload.value();
        emailService.receiveMsgToKafka(payload.value());
    }
}
