package org.ubt.order.controller;

import org.springframework.web.bind.annotation.*;
import org.ubt.order.model.Order;
import org.ubt.order.service.OrderService;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/getTotalPrice")
    public void calculateTotalPrice(@RequestBody Order order){
        orderService.calculateTotalPrice(order);
    }
}
