package com.example.craftsofttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class CraftsoftTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(CraftsoftTestApplication.class, args);
    }

    @Bean
    public Docket swaggerConfiguration() {
        //  Return a prepared Docket instance
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.craftsofttest"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Task Management System",
                "Details of the entire project",
                "1.0",
                "Full Free",
                new springfox.documentation.service.Contact("Shamin Asfaq", "https://www.google.com/", "a@b.com"),
                "API License",
                "https://www.google.com",
                Collections.emptyList()
        );
    }

}
