package br.unicamp.educorp.microservices.cardapios.api.aula11.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.unicamp.educorp.microservices.cardapios.api.aula11.model.dto.RestauranteDto;

@FeignClient(value = "restaurantes-service", configuration = FeignConfiguration.class, fallback = RestauranteClientFallback.class)
public interface RestauranteClient {

	@GetMapping("/restaurantes/{id}")
	RestauranteDto getRestaurante(@PathVariable Integer id);
}
