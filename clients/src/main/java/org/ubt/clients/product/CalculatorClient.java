package org.ubt.clients.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="calc-svc",url="http://localhost:8087")
public interface CalculatorClient {

    @GetMapping("/discount/{couponCode}/{price}/{discount}")
    Double getDiscount(@PathVariable("couponCode") String couponCode, @PathVariable("price") Double price,
                       @PathVariable("discount") double discount);
}
