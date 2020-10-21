package br.unicamp.educorp.microservices.profile.aula5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ProfileAula5Application {

	private static final Logger log = LoggerFactory.getLogger(ProfileAula5Application.class);

	@Value("${myapp.title}")
	private String titulo;

	@Value("${myapp.message}")
	private String mensagem;

	public static void main(String[] args) {
		SpringApplication.run(ProfileAula5Application.class, args);
	}

	@Bean
	@Profile("dev")
	public CommandLineRunner readMessageAndTitleDev() {
		return args -> {
			log.info("dev titulo={}", titulo);
			log.info("dev mensagem={}", mensagem);
		};
	}

	@Bean
	@Profile("test")
	public CommandLineRunner readMessageAndTitleTest() {
		return args -> {
			log.info("test titulo={}", titulo);
			log.info("test mensagem={}", mensagem);
		};
	}

	@Bean
	@Profile("prod")
	public CommandLineRunner readMessageAndTitleProd() {
		return args -> {
			log.info("prod titulo={}", titulo);
			log.info("prod mensagem={}", mensagem);
		};
	}

	@Bean
	public CommandLineRunner readMessageAndTitle() {
		return args -> {
			log.info("default titulo={}", titulo);
			log.info("default mensagem={}", mensagem);
		};
	}
}
