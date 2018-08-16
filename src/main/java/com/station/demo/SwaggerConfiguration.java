package com.station.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfiguration  {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.station.demo.controller"))
				.build().apiInfo(metaData());

	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Spring Boot  StationDemo REST API", "Spring Boot RadioStation for App Store", "1.0",
				"Apps service",
				new Contact("Vinay N. Pandya", "vinaypandya@yahoo.com", "vinaypandya@yahoo.com"),
				"StationDemo", "StationDemo");
		return apiInfo;
	}

}
