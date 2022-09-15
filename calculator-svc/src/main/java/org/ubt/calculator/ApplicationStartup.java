package org.ubt.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.ubt.calculator.service.ExchangeService;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private ExchangeService exchangeService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
//        exchangeService.fetchExchange();
    }
}
