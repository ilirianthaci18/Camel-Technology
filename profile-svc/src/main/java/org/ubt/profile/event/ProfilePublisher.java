package org.ubt.profile.event;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ProfilePublisher {
    //TODO refactor TOPIC names and methods
    private static final String TOPIC="wishlist-product";

    private Publisher publisher;

    public ProfilePublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void publishMsg(List<String> msg){
        log.info("Producing msg with topic {} and msg {} ",TOPIC,msg);
        msg.forEach(message -> this.publisher.publishEvent(new ProducerRecord<>(TOPIC,message)));
    }

}
