package com.fmontiel.restapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * The class Swagger configuration.
 *
 * @author Fernando Montiel Meza.
 */
@Configuration
public class SwaggerConfiguration {

    /**
     * Docket docket.
     *
     * @return the docket
     */
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(getApiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.fmontiel.restapi.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * Gets api info.
     *
     * @return the api info
     */
    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder().title("Test rest api Spring Boot")
                .description("Example REST service that transforms time and timezone into UTC time")
                .contact(new Contact("Fernando Montiel Meza", "https://github.com/fmontielmeza",
                        "fmontielmeza@gmail.com"))
                .build();
    }
}
