package org.ubt.calculator.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.ubt.calculator.service.DiscountService;

@CrossOrigin(originPatterns = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/calculator")
@Slf4j
public class CalculatorController {

    private DiscountService discountService;

    @GetMapping("/discount/{couponCode}/{price}/{discount}")
    public Double getDiscount(@PathVariable("couponCode") String couponCode,@PathVariable("price") Double price,
                              @PathVariable("discount") double discount){
        return discountService.calculatePrice(couponCode,price,discount);
    }
}
