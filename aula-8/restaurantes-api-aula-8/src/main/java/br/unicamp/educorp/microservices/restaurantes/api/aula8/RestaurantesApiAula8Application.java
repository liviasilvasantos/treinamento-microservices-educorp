package br.unicamp.educorp.microservices.restaurantes.api.aula8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableDiscoveryClient
public class RestaurantesApiAula8Application {

	private static final Logger log = LoggerFactory.getLogger(RestaurantesApiAula8Application.class);

	@Value("${app.titulo}")
	private String titulo;

	@Value("${app.mensagem}")
	private String mensagem;

	public static void main(String[] args) {
		SpringApplication.run(RestaurantesApiAula8Application.class, args);
	}

	@Bean
	public CommandLineRunner readMessageAndTitle() {
		return args -> {
			log.info("*** titulo={}, mensagem={}", titulo, mensagem);
		};
	}

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}

}
