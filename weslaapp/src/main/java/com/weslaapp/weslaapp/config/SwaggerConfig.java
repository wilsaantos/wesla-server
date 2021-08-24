package com.weslaapp.weslaapp.config;


import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket carApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.weslaapp.weslaapp"))
                .paths(regex("/cars.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        ApiInfo apiInfo = new ApiInfo(
        "Wesla API REST",
        "API Rest Cadastro de Carros.",
        "1.0",
        "Terms of Service",
        new Contact("Wilson Santos", "https://www.youtube.com/user/wilsinhosaanBR", "wilson.saantos@hotmail.com"),
        "Apache License Version 2.0",
        "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()

        );

    return apiInfo;
    }
}
