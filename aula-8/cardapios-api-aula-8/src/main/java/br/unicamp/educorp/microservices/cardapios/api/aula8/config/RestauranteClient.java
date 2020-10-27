package br.unicamp.educorp.microservices.cardapios.api.aula8.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import br.unicamp.educorp.microservices.cardapios.api.aula8.model.dto.RestauranteDto;
import reactor.core.publisher.Mono;

@Configuration
public class RestauranteClient {

	private static final Logger log = LoggerFactory.getLogger(RestauranteClient.class);

	@Bean
	public CommandLineRunner runRestTemplate(RestTemplate restTemplate) throws Exception {
		return args -> {
			RestauranteDto outback = restTemplate.getForObject("http://localhost:8180/restaurantes/api/restaurantes/2",
					RestauranteDto.class);
			log.info("dados outback {}", outback);
		};
	}

	@Bean
	public CommandLineRunner runWebClient() throws Exception {
		return args -> {

			WebClient client = WebClient.create("http://localhost:8180/restaurantes/api/restaurantes");

			Mono<RestauranteDto> outback = client.get().uri("/{id}", 2).retrieve().bodyToMono(RestauranteDto.class);

			log.info("dados outback {}", outback.block());
		};
	}
}
