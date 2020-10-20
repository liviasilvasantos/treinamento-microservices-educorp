package br.unicamp.educorp.microservices.cursos.api.aula5.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2) //
				.select() //
				// .apis(RequestHandlerSelectors.basePackage("br.unicamp.educorp.microservices.cursos.api.aula5"))
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))//
				.paths(PathSelectors.any())//
				.build()//
				.useDefaultResponseMessages(false) //
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfo("Cursos - REST API", // title
				"API Rest de Cursos Oferecidos na Educorp - Curso de Microservices.", // description
				"V6", // version
				"Terms of service", // terms of service url
				new Contact("Lívia Silva Santos", "www.unicamp.br", "liviass@unicamp.br"), // contact
				"License of API", // license
				"API license URL", // license url
				Collections.emptyList());
	}
}
