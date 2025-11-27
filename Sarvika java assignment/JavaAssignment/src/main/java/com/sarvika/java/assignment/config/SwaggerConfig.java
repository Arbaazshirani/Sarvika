package com.sarvika.java.assignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("Java Assignment").version("1.0")
				.description("API documentation for Sarvika Java Assignment.")

				.contact(new Contact().name("Sarvika Technologies Pvt. Ltd.").url("https://www.sarvika.com/")
						.email("humanresources@sarvika.com"))
				.license(new License().name("API License").url("http://example.com/license")));
	}

}
