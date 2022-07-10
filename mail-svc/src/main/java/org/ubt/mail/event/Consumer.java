package org.ubt.mail.event;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;
import org.ubt.mail.common.dto.OrderEmailDTO;
import org.ubt.mail.service.EmailService;

import java.io.DataInput;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static ch.qos.logback.core.joran.util.beans.BeanUtil.isGetter;

@AllArgsConstructor
@Component
@Slf4j
public class Consumer {

    private EmailService emailService;

    @SneakyThrows
    @KafkaListener(topics = "order-email",groupId = "group-id-1")
    public void listen(ConsumerRecord<String,Object> payload){
        log.info("Getting kafka message {} ",payload.value());
//        OrderEmailDTO orderEmailDTO=payload.value();
//        ObjectMapper objectMapper=new ObjectMapper();
//        OrderEmailDTO emailDTO=objectMapper.readValue((String) payload.value(),OrderEmailDTO.class);
//        log.info("This is it ttt {} ",emailDTO);
//        payload.value().getClass().getMethod("getEmail").invoke(payload.value());
//        OrderEmailDTO orderEmailDTO= (OrderEmailDTO) payload.value().getClass().cast(OrderEmailDTO.class);
//        System.out.println(orderEmailDTO.getEmail());
        emailService.receiveMsgToKafka(payload.value());
    }
}
