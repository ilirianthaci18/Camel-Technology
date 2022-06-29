package org.ubt.order.controller;

import org.aspectj.weaver.ast.Or;
import org.springframework.web.bind.annotation.*;
import org.ubt.order.model.Order;
import org.ubt.order.service.OrderService;
import org.ubt.order.service.OrderTakingService;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/v1/order")
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
        orderTakingService.saveOrderToRedis(order);
    }
}
