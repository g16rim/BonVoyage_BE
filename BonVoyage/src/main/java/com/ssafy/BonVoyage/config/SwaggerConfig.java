package com.ssafy.BonVoyage.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "bonVoyage REST API",
                version = "3.0.0",
                description = "spring doc를 사용한 bonVoyage API"
        ),
        servers = @Server(url = "/")
)

@Component
public class SwaggerConfig {


    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("lsh")
                .packagesToScan("com.chat.project.controller")
                .pathsToMatch("/public/**")
                .build();
    }


//    @Bean
//    public OpenApiCustomiser buildSecurityOpenApi() {
//        return OpenApi -> OpenApi.addSecurityItem(new SecurityRequirement().addList("jwt token"))
//                .getComponents().addSecuritySchemes("jwt token", new SecurityScheme()
//                        .name("Authorization")
//                        .type(SecurityScheme.Type.HTTP)
//                        .in(SecurityScheme.In.HEADER)
//                        .bearerFormat("JWT")
//                        .scheme("bearer"));
//    }
}