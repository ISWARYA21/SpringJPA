package com.jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
//@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.jpa"))
				.paths(PathSelectors.any())
				.build().apiInfo(apiEndPointInfo());
	}
	
	public ApiInfo apiEndPointInfo() {
		return new ApiInfoBuilder().title("Spring Boot Project REST API")
				.contact(new Contact("Rest Api", "www.google.com", "ganeshkrish31079@gmail.com"))
				.license("Apache 2.0")
				.licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("0.0.1-SNAPSHOT")
				.build();
	}

}
