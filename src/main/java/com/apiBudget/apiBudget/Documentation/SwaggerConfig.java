package com.apiBudget.apiBudget.Documentation;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI Swagger() {

        return new OpenAPI()
                .info(new Info().title("apiBudget")
                        .description("API de gestion de budget personnel. Permet aux utilisateurs des planifier et gerer " +
                                "leurs depenses en avance.")
                        .version("1.0"));
    }
}
