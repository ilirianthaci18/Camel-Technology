package org.ubt.calculator.service;

import io.github.dengliming.redismodule.redisjson.RedisJSON;
import io.github.dengliming.redismodule.redisjson.args.GetArgs;
import io.github.dengliming.redismodule.redisjson.args.SetArgs;
import io.github.dengliming.redismodule.redisjson.utils.GsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.ubt.calculator.config.HttpUtils;
import org.ubt.calculator.event.CalculatorPublisher;
import org.ubt.calculator.model.Exchange;

@Service
@Slf4j
public class ExchangeService {
    public static final String GET_EXCHANGE_API="https://currency-converter13.p.rapidapi.com/convert?from=EUR&to=USD&amount=1";
    public static final String REDIS_KEY_EXCHANGE_USD="Exchange-usd";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisJSON redisJSON;

    private CalculatorPublisher calculatorPublisher;

    public ExchangeService(CalculatorPublisher calculatorPublisher) {
        this.calculatorPublisher = calculatorPublisher;
    }

    public void fetchExchange(){
        log.info("Inside fetchExchange()");
        ResponseEntity<Exchange> exchange = restTemplate.exchange(GET_EXCHANGE_API, HttpMethod.GET, HttpUtils.getHttpEntity(), Exchange.class);
        log.info(exchange.toString());
        calculatorPublisher.publishMsg(exchange.getBody().getAmount());
        storeExchangeToRedisJSON(exchange.getBody());
    }

    private void storeExchangeToRedisJSON(Exchange exchangeRate){
        log.info(exchangeRate.toString());
        redisJSON.set(REDIS_KEY_EXCHANGE_USD, SetArgs.Builder.create(".", GsonUtils.toJson(exchangeRate)));
    }

    public Double getExchangeFromRedis(){
        Exchange exchange = redisJSON.get(REDIS_KEY_EXCHANGE_USD , Exchange.class, new GetArgs().path(".").indent("\t").newLine("\n").space(" "));
//        log.info(exchange.toString());
        return exchange.getAmount();
    }
}
