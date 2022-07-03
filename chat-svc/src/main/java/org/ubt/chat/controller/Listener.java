package org.ubt.chat.controller;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import org.ubt.chat.Constants;
import org.ubt.chat.model.Message;

@Component
public class Listener {

    private static final Logger LOG = LoggerFactory.getLogger(Listener.class);

    @Autowired
    private SimpMessagingTemplate webSocket;

    @KafkaListener(topics = Constants.KAFKA_TOPIC)
    public void processMessage(ConsumerRecord<String, String> cr, @Payload Message content) {
        LOG.info("Received content from Kafka: {}", content);

        this.webSocket.convertAndSend(Constants.WEBSOCKET_DESTINATION, content.getMessage());
    }

}