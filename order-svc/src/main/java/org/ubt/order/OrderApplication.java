package org.ubt.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "org.ubt.order")
//@ComponentScan(basePackages = {"org.ubt.order.repository","org.ubt.order.controller","org.ubt.order.service"})
//@EnableJpaRepositories("org.ubt.order.repository")
@EntityScan("org.ubt.order.model")
@EnableEurekaClient
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
