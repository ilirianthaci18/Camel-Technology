package org.ubt.calculator.event;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.ubt.calculator.common.dto.PriceCalculationDiscountDTO;
import org.ubt.calculator.service.DiscountService;

import static org.ubt.calculator.common.mapper.DiscountMapper.discountPriceDto;

@AllArgsConstructor
@Slf4j
@Component
public class CalculatorConsumer {

    private DiscountService discountService;

    @KafkaListener(topics="price-coupon",groupId = "group-id-1")
    public void listen(ConsumerRecord<String, Object> payload){
        log.info("Getting kafka message \n {} ", payload.value());
        discountService.calculatePrice(discountPriceDto(payload.value()));
    }
}
