package br.unicamp.educorp.microservices.cardapios.api.aula10.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import br.unicamp.educorp.microservices.cardapios.api.aula10.model.dto.RestauranteDto;
import reactor.core.publisher.Mono;

//@Configuration
public class RestauranteTestClient {

	private static final Logger log = LoggerFactory.getLogger(RestauranteTestClient.class);

	// @Bean
	public CommandLineRunner runRestTemplate(RestTemplate restTemplate) throws Exception {
		return args -> {
			RestauranteDto outback = restTemplate.getForObject("http://localhost:8180/restaurantes/2",
					RestauranteDto.class);
			log.info("rest template - dados outback {}", outback);
		};
	}

	// @Bean
	public CommandLineRunner runWebClient() throws Exception {
		return args -> {

			WebClient client = WebClient//
					.create("http://localhost:8180");

			Mono<RestauranteDto> outback = client//
					.get()//
					.uri("/restaurantes/{id}", 2)//
					.retrieve()//
					.bodyToMono(RestauranteDto.class);

			log.info("web client - dados outback {}", outback.block());
		};
	}
}
