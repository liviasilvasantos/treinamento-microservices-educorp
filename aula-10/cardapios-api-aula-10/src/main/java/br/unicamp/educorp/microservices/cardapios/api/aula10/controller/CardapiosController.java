package br.unicamp.educorp.microservices.cardapios.api.aula10.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.educorp.microservices.cardapios.api.aula10.client.RestauranteClient;
import br.unicamp.educorp.microservices.cardapios.api.aula10.model.Cardapio;
import br.unicamp.educorp.microservices.cardapios.api.aula10.model.dto.RestauranteDto;
import br.unicamp.educorp.microservices.cardapios.api.aula10.repository.CardapiosRepository;

@RestController
@RequestMapping("/cardapios")
public class CardapiosController {

	private static final Logger log = LoggerFactory.getLogger(CardapiosController.class);

	@Autowired
	private CardapiosRepository cardapiosRepository;

	@Autowired
	private RestauranteClient restauranteClient;

	@Autowired
	private HttpServletRequest requestContext;

	@GetMapping
	public ResponseEntity<List<Cardapio>> getAll() {
		log.info("getAll [trx-id={}]", requestContext.getHeader("trx-id"));

		List<Cardapio> cardapios = cardapiosRepository.buscarTodosCardapiosComItens();
		cardapios.forEach(c -> {
			RestauranteDto restaurante = restauranteClient.getRestaurante(c.getIdRestaurante());
			c.setRestaurante(restaurante);
		});

		return ResponseEntity.ok(cardapios);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cardapio> getById(@PathVariable Integer id) {
		log.info("getById {} [trx-id={}]", id, requestContext.getHeader("trx-id"));

		Optional<Cardapio> cardapio = cardapiosRepository.buscarCardapioComItens(id);

		if (cardapio.isPresent()) {

			Cardapio c = cardapio.get();
			RestauranteDto restaurante = restauranteClient.getRestaurante(c.getIdRestaurante());
			c.setRestaurante(restaurante);

			return ResponseEntity.ok(c);

		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
