package br.unicamp.educorp.microservices.cardapios.api.aula8.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.educorp.microservices.cardapios.api.aula8.model.Cardapio;
import br.unicamp.educorp.microservices.cardapios.api.aula8.repository.CardapiosRepository;

@RestController
@RequestMapping("/cardapios")
public class CardapiosController {

	private static final Logger log = LoggerFactory.getLogger(CardapiosController.class);

	@Autowired
	private CardapiosRepository cardapiosRepository;

	@GetMapping
	public ResponseEntity<List<Cardapio>> getAll() {
		log.info("getAll");
		return ResponseEntity.ok(cardapiosRepository.buscarTodosCardapiosComItens());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cardapio> getById(@PathVariable Integer id) {
		log.info("getById {}", id);
		return ResponseEntity.ok(cardapiosRepository.findById(id).get());
	}
}
