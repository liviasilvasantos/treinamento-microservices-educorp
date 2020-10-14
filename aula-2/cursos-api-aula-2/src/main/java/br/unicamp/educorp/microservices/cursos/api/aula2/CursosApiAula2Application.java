package br.unicamp.educorp.microservices.cursos.api.aula2;

import java.util.Map;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CursosApiAula2Application {

	public static void main(String[] args) {
		SpringApplication.run(CursosApiAula2Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args -> {
			System.out.println("### Listando os beans providos pelo Spring Boot:");
			Stream.of(context.getBeanDefinitionNames())//
					.sorted()//
					.forEach(System.out::println);

			System.out.println("### Listando os beans RestController:");
			Map<String, Object> restBeans = context.getBeansWithAnnotation(RestController.class);
			restBeans//
					.forEach((k, v) -> System.out.println(k + " : " + v));
		};
	}
}
