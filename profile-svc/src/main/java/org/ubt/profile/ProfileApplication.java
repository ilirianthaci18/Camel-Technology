package org.ubt.profile;

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
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.net.MalformedURLException;
import java.net.URL;


@EnableCaching
@SpringBootApplication(scanBasePackages = {"org.ubt.profile"})
@EntityScan("org.ubt.profile.model")
//@EnableJpaRepositories
@EnableEurekaClient
@EnableFeignClients(basePackages = "org.ubt.clients")
public class ProfileApplication {

    @Value("${spring.jwt.aws.connectionTimeout}")
    private int connectionTimeout;

    @Value("${spring.jwt.aws.readTimeout}")
    private int readTimeout;

    @Value("${spring.jwt.aws.jwkUrl}")
    private String jwkUrl;

    public static void main(String[] args) {
        SpringApplication.run(ProfileApplication.class,args);
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

