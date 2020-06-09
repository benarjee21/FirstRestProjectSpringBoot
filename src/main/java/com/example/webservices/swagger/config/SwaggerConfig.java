package com.example.webservices.swagger.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

//configuration
//Enable Swagger2
@Configuration
//@EnableSwagger2
@EnableSwagger2WebMvc
public class SwaggerConfig {
	private static final Contact DEFAULT_CONTACT = new Contact("Vikky","www.vikky.com","vikky@gmail.com");
	private static final ApiInfo DFAULT_API_INFO = new ApiInfo(
		      "My Api Documentation",
		      "My Api Documentation",
		      "1.0",
		      "urn:tos",
		      DEFAULT_CONTACT,
		      "Apache 2.0",
		      "http://www.apache.org/licenses/LICENSE-2.0",
		      new ArrayList<>());
	private static final Set<String> DFAULT_PRODUCES_CONSUMERS = new HashSet<String>(
			Arrays.asList("application/json","application/xml"));
	

	//bean-doket
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(DFAULT_API_INFO)
				.produces(DFAULT_PRODUCES_CONSUMERS)
				.consumes(DFAULT_PRODUCES_CONSUMERS);
	}
	
	//swagger 2
	//A1l paths
	//All apis
}
