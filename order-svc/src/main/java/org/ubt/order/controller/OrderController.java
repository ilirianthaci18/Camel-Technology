package org.ubt.order.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ubt.order.model.Order;
import org.ubt.order.model.OrderStatusDTO;
import org.ubt.order.service.OrderService;
import org.ubt.order.service.OrderTakingService;

@CrossOrigin(originPatterns = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/order")
@Slf4j
public class OrderController {

    private OrderService orderService;
    private OrderTakingService orderTakingService;

    public OrderController(OrderService orderService, OrderTakingService orderTakingService) {
        this.orderService = orderService;
        this.orderTakingService = orderTakingService;
    }

    @PostMapping("/getTotalPrice")
    public void calculateTotalPrice(@RequestBody Order order){
        orderService.calculateTotalPrice(order);
    }

    @PostMapping("/saveToRedis")
    public void saveToRedis(@RequestBody Order order){
        //we should get the orderid from stripe and set it to this object and then save it to redis
//        orderTakingService.saveOrderToRedis(order);
    }

    @GetMapping("/1")
    public int getTest(){
        log.info("test");
        return 1;
    }
    @PostMapping("/orderStatus")
    public void orderService(@RequestBody OrderStatusDTO orderStatusDTO){
        log.info("test2 {}",orderStatusDTO.isStatus());
        log.info("test2 {}",orderStatusDTO.getOrderId());
        orderService.updateOrder(orderStatusDTO);
    }
}
