package br.unicamp.educorp.microservices.cursos.api.aula7.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.educorp.microservices.cursos.api.aula7.model.Curso;
import br.unicamp.educorp.microservices.cursos.api.aula7.repository.CursosRepository;

@RestController
public class CursosController {

	private static final Logger log = LoggerFactory.getLogger(CursosController.class);

	@Autowired
	private CursosRepository cursoRepository;

	@Autowired
	private Environment environment;

	// Crud
	private String getHostPorta() {
		return environment.getProperty("local.server.port");
	}

	@GetMapping("/v7/cursos")
	public ResponseEntity<List<Curso>> getAllCursos() {
		log.info("buscando todos os cursos na porta {}", getHostPorta());
		return new ResponseEntity<List<Curso>>(cursoRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/v7/cursos/{id}")
	public ResponseEntity<Curso> getCurso(@PathVariable Integer id) {
		log.info("buscando o curso {} na porta {}", id, getHostPorta());

		Optional<Curso> curso = cursoRepository.findById(id);

		if (curso.isPresent()) {
			return new ResponseEntity<Curso>(cursoRepository.findById(id).get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/v7/cursos")
	public ResponseEntity<Curso> saveCurso(@RequestBody Curso curso) {
		log.info("salvando novo curso {} na porta {}", curso, getHostPorta());
		try {
			return new ResponseEntity<Curso>(cursoRepository.save(curso), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Curso>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/v7/cursos/{id}")
	public ResponseEntity<Curso> deleteCurso(@PathVariable Integer id) {
		log.info("excluindo curso {} na porta {}", id, getHostPorta());
		try {
			cursoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return new ResponseEntity<Curso>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/v7/cursos/{id}")
	public ResponseEntity<Curso> saveCurso(@PathVariable Integer id, @RequestBody Curso curso) {
		log.info("atualizando curso id {} na porta {}", id, getHostPorta());

		Optional<Curso> cursoEntity = cursoRepository.findById(id);

		if (cursoEntity.isPresent()) {
			Curso _curso = cursoEntity.get();
			_curso.setCodigo(curso.getCodigo());
			_curso.setDescricao(curso.getDescricao());
			return new ResponseEntity<Curso>(cursoRepository.save(curso), HttpStatus.OK);
		} else {
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
	}

}
