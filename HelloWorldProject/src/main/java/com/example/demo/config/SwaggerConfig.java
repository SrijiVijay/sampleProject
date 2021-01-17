package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Sample demo for CICD demo
 * 
 * @author sriji.n
 *
 */

//URL  to see documentation
//http://localhost:9090/nsure/swagger-ui.html
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	
	@Bean
	public Docket restApi(){
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.example.demo.controllers"))
		.paths(PathSelectors.any())
		.build()
		.apiInfo(apiInfo());

	}

	public ApiInfo apiInfo() {
		return new ApiInfo(
					"Spring Boot REST API", 
					"Spring Boot REST API for Demo Application", 
					"1.0",
					"Terms of service", 
					 new Contact(
							 "Spring Swagger", 
							 "http://www.spring.io/", 
							 "sample@gmail.com"
					),
					"Apache License Version 2.0",
					"https://www.apache.org/licenses/LICENSE-2.0"
				);
	}
	
}