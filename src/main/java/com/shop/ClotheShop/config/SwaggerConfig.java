package com.shop.ClotheShop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;

@Configuration
public class SwaggerConfig {

        @Bean
        public OpenAPI openAPI() {
                return new OpenAPI()
                                .info(new Info()
                                                .title("Clothe Shop API")
                                                .version("1.0"))
                                .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
                                .components(new Components()
                                                .addSecuritySchemes("basicAuth",
                                                                new SecurityScheme()
                                                                                .type(SecurityScheme.Type.HTTP)
                                                                                .scheme("basic")));
        }
}