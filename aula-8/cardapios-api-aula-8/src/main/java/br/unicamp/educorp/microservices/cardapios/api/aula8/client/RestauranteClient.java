package br.unicamp.educorp.microservices.cardapios.api.aula8.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.unicamp.educorp.microservices.cardapios.api.aula8.model.dto.RestauranteDto;

//sem ribbon
//@FeignClient(value = "restaurantes-service", url = "http://localhost:8180/restaurantes/api")

//com ribbon/eureka
@FeignClient(value = "restaurantes-service", path = "/restaurantes/api", configuration = FeignConfiguration.class)
public interface RestauranteClient {

	@RequestMapping(method = RequestMethod.GET, value = "/restaurantes/{id}")
	RestauranteDto getRestaurante(@PathVariable Integer id);
}
