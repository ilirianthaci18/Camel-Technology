package org.ubt.calculator.event;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CalculatorPublisher {
    private static final String TOPIC="rate-exchange";
    private static final String TOPIC2="calculated-price";

    private Publisher publisher;

    public CalculatorPublisher( Publisher publisher) {
        this.publisher = publisher;
    }

    public void publishMsg(Double msg){
        log.info("Producing msg with topic {} and msg {} ",TOPIC,msg);

        this.publisher.publishEvent(new ProducerRecord<>(TOPIC,msg));
    }

    public void publishCalculatedPrice(String msg){
        log.info("Producing msg with topic {} and msg {} ",TOPIC2,msg);

        this.publisher.publishEvent(new ProducerRecord<>(TOPIC2,msg));
    }
}
