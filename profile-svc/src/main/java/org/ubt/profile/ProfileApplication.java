package org.ubt.profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableCaching
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "org.ubt.clients")
public class ProfileApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProfileApplication.class,args);
    }
}

