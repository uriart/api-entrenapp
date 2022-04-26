package com.grupo.apirest.controller;

import com.google.common.net.HttpHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private final List<SecurityReference> securityReference = Collections.singletonList(SecurityReference.builder()
            .reference("JWT")
            .scopes(new AuthorizationScope[0])
            .build()
    );

    @Bean
    public Docket powerlifting() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(Arrays.asList(new ApiKey("JWT", HttpHeaders.AUTHORIZATION, "header" )))
                .securityContexts(Arrays.asList(SecurityContext.builder()
                .securityReferences(securityReference).build()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/powerlifting/.*"))
                .build()
                .groupName("programa-powerlifting");
    }

    /**
     * Info del API
     */
    private ApiInfo informacionApi(String titulo) {
        return new ApiInfoBuilder()
                .title("Aplicación API")
                .description(titulo)
                .build();
    }
}
