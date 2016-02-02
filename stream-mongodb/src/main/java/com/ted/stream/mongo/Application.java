package com.ted.stream.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createApiInfo()).select().build();
    }

    private ApiInfo createApiInfo() {
        final ApiInfo apiInfo = new ApiInfo("TED Stream API", "This is the API for TED Stream", "1.0", "#/termsOfServiceUrl.html",
            "TED", "License", "#/licenseUrl.html");
        return apiInfo;
    }
}
