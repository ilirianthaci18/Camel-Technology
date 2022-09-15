package org.ubt.order;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.jwk.source.RemoteJWKSet;
import com.nimbusds.jose.proc.JWSKeySelector;
import com.nimbusds.jose.proc.JWSVerificationKeySelector;
import com.nimbusds.jose.util.DefaultResourceRetriever;
import com.nimbusds.jose.util.ResourceRetriever;
import com.nimbusds.jwt.proc.ConfigurableJWTProcessor;
import com.nimbusds.jwt.proc.DefaultJWTProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootApplication(scanBasePackages = {"org.ubt.order"})
//@ComponentScan(basePackages = {"org.ubt.order.repository","org.ubt.order.controller","org.ubt.order.service"})
//@EnableJpaRepositories("org.ubt.order.repository")
@EntityScan("org.ubt.order.model")
@EnableEurekaClient
public class OrderApplication {
    @Value("${spring.jwt.aws.connectionTimeout}")
    private int connectionTimeout;

    @Value("${spring.jwt.aws.readTimeout}")
    private int readTimeout;

    @Value("${spring.jwt.aws.jwkUrl}")
    private String jwkUrl;

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }

    @Bean
    public ConfigurableJWTProcessor configurableJWTProcessor() throws MalformedURLException {
        ResourceRetriever resourceRetriever=new DefaultResourceRetriever(connectionTimeout,readTimeout);

        URL jwkUrl2=new URL(jwkUrl);

        JWKSource jwkSource = new RemoteJWKSet(jwkUrl2, resourceRetriever);
        ConfigurableJWTProcessor jwtProcessor = new DefaultJWTProcessor();
        JWSKeySelector keySelector = new JWSVerificationKeySelector(JWSAlgorithm.RS256, jwkSource);
        jwtProcessor.setJWSKeySelector(keySelector);

        return jwtProcessor;
    }
}
