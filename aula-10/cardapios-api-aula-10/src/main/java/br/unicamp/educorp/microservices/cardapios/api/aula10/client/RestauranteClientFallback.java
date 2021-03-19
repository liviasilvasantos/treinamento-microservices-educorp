package br.unicamp.educorp.microservices.cardapios.api.aula10.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import br.unicamp.educorp.microservices.cardapios.api.aula10.model.dto.RestauranteDto;

@Component
public class RestauranteClientFallback implements RestauranteClient {

	private static final Logger log = LoggerFactory.getLogger(RestauranteClientFallback.class);

	@Override
	public RestauranteDto getRestaurante(Integer id) {
		log.error("não foi possível localizar o restaurante de id {}", id);
		return new RestauranteDto("Não foi possível localizar o restaurante de id " + id);
	}

}
