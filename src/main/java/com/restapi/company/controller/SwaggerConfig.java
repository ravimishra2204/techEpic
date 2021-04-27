package com.restapi.company.controller;

import org.springframework.context.annotation.*;

import springfox.documentation.builders.*;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	    @Bean
	    public Docket productApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()                 
	                .apis(RequestHandlerSelectors.basePackage("com.restapi.company.controller"))
	                .paths(PathSelectors.any())
	                .build().apiInfo(metaInfo());

	    }
	    
	    private ApiInfo metaInfo() {
	    	
	    	return new ApiInfoBuilder().title("Company Managment Service").
	    			description ("This is to maintain Company service").build();
	    }
	}
	
