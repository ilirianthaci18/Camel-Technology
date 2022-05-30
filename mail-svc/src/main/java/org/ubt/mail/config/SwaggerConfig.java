package org.ubt.mail.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(getApiInfo());
    }

    private Info getApiInfo() {
        return new Info()
                .title("Mail API")
                .description("Documentation of API Endpoints")
                .version("v1.0")
                .license(null)
                .termsOfService("Terms of service");
    }

}
