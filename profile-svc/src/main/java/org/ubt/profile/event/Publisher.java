package org.ubt.profile.event;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@Component
public class Publisher {

    private KafkaTemplate<String,Object> kafkaTemplate;

    public Publisher(KafkaTemplate<String,Object> kafkaTemplate){this.kafkaTemplate=kafkaTemplate;}

    public void publishEvent(ProducerRecord<String,Object> producerRecord){
        kafkaTemplate.send(producerRecord).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("Something went wrong while publish message to kafka: {}", ex.getLocalizedMessage(), ex);
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                log.info("Message published successfully to kafka topic {}, offset: {}, timestamp: {}",
                        result.getRecordMetadata().topic(), result.getRecordMetadata().offset(),
                        result.getRecordMetadata().timestamp()
                );
                log.info("Published message: {}", result.getProducerRecord().value());
            }
        });
    }
}
