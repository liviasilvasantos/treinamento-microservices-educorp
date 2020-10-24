package br.unicamp.educorp.microservices.cursos.api.aula7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursosApiAula7Application {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(CursosApiAula7Application.class, args);
	}

}
