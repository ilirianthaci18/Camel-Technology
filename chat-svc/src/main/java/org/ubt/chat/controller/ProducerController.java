package org.ubt.chat.controller;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.ubt.chat.Constants;
import org.ubt.chat.model.Message;

/**
 * Generate sample messages.
 *
 * Use: GET /kafla/sample/{amount}.
 */
@RestController
@RequestMapping(value = "/api/kafka")
public class ProducerController {

    private static final Logger LOG = LoggerFactory.getLogger(ProducerController.class);

    private ProducerCallback producerCallback = new ProducerCallback();

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping(value = "/sample/{amount}", method = RequestMethod.GET)
    public void generateMessages(@PathVariable("amount") Integer amount) {

        //IntStream.range(0, amount)
        //        .peek(i -> this.waitFor(1))
         //       .mapToObj(i -> new Message("Message " + i))
         //       .forEach(this::sendToKafka);

        sendToKafka("Message new message");
    }

    private void sendToKafka(String message) {
        this.kafkaTemplate
                .send(Constants.KAFKA_TOPIC, UUID.randomUUID().toString(), message)
                .addCallback(this.producerCallback);
    }

    private void waitFor(int seconds) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        Future<Void> future = scheduler.schedule(() -> null, seconds, TimeUnit.SECONDS);
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    class ProducerCallback implements ListenableFutureCallback<SendResult<String, String>> {
        @Override
        public void onSuccess(SendResult<String, String> result) {
            RecordMetadata record = result.getRecordMetadata();
            LOG.info("Sending {} to topic {} - partition {}",
                    result.getProducerRecord().key(),
                    result.getProducerRecord().topic(),
                    record.partition());
        }

        @Override
        public void onFailure(Throwable ex) {
            LOG.error("Producer Failure", ex);
        }
    }

}