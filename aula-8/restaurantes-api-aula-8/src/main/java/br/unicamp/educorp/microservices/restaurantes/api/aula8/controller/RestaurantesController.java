package br.unicamp.educorp.microservices.restaurantes.api.aula8.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.educorp.microservices.restaurantes.api.aula8.exception.RestauranteNaoEncontradoException;
import br.unicamp.educorp.microservices.restaurantes.api.aula8.model.Restaurante;
import br.unicamp.educorp.microservices.restaurantes.api.aula8.service.RestaurantesService;

@RestController
@RequestMapping("/restaurantes")
public class RestaurantesController {

	private static final Logger log = LoggerFactory.getLogger(RestaurantesController.class);

	@Autowired
	private RestaurantesService restaurantesService;

	@GetMapping
	public ResponseEntity<List<Restaurante>> getAll() {
		log.info("getAll");
		return ResponseEntity.ok(restaurantesService.buscarRestaurantes());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Restaurante> getById(@PathVariable Integer id) throws RestauranteNaoEncontradoException {
		log.info("getById {}", id);
		return ResponseEntity.ok(restaurantesService.buscarRestaurante(id));
	}

	@PostMapping()
	public ResponseEntity<Restaurante> newRestaurante(@RequestBody Restaurante restaurante) {
		log.info("newRestaurante {}", restaurante);
		try {
			return new ResponseEntity<Restaurante>(restaurantesService.salvarRestaurante(restaurante),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Restaurante>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Restaurante> deleteRestaurante(@PathVariable Integer id) {
		log.info("deleteRestaurante {}", id);
		try {
			restaurantesService.excluirRestaurante(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return new ResponseEntity<Restaurante>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
