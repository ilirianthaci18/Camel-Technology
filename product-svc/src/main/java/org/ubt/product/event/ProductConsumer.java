package org.ubt.product.event;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.ubt.product.service.InventoryService;
import org.ubt.product.service.ProductService;

@AllArgsConstructor
@Slf4j
@Component
public class ProductConsumer {
    private ProductService productService;
    private InventoryService inventoryService;

    @KafkaListener(topics="rate-exchange",groupId = "group-id-1")
    public void listen(ConsumerRecord<String,Object> payload){
        log.info("Getting kafka message {} ",payload.value());
        productService.receiveMessage(payload.value());
    }

    //TODO refactor
    @KafkaListener(topics="product-codes",groupId = "group-id-1")
    public void listen2(ConsumerRecord<String,String> payload){
//        String str = payload.value().replaceAll("[-+^]*", "");
        String str=payload.value().substring(1,payload.value().length()-1);
        log.info("Getting kafka message {} and with key {}",str,payload.key());

//        productService.removeQuantityWhileOrdering(str);
        //TODO use ConsumerRecord key as product code , value as quantity
//        productService.removeProductQuantity(str,1);
        inventoryService.removeProductQuantity(str,1);
    }

    @KafkaListener(topics = "wishlist-product",groupId = "group-id-1")
    public void listen3(ConsumerRecord<String,String> payload){
        String str=payload.value().substring(1,payload.value().length()-1);
        log.info("Getting kafka message {}",str);

        productService.acceptMessageFromProfile(str);
    }
}

