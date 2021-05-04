package com.springbootworkshop.addressbookproject.swagger;

import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket swaggerSettingsApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.springbootworkshop.addressbookproject.controllers"))
                .paths(regex("/AddressBook.*"))
                .build();
    }



    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("AddressBook Project Using")
                .description("AddressBook Rest API Documentation Generated Using SWAGGER 2 ")
                .termsOfServiceUrl("https://github.com/IamSanketMore/SpringBootWorkShop_AddressBook.git")
                .version("spring boot").build();
    }
}

//http://localhost:8080/swagger-ui.html#/