package br.unicamp.educorp.microservices.config.aula11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigAula11Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigAula11Application.class, args);
	}

}
