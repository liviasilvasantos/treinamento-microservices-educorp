package br.unicamp.educorp.microservices.admin.server.aula7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class AdminServerAula7Application {

	public static void main(String[] args) {
		SpringApplication.run(AdminServerAula7Application.class, args);
	}

}
