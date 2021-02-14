package br.unicamp.educorp.microservices.cursos.api.aula4.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.educorp.microservices.cursos.api.aula4.jwt.model.Curso;
import br.unicamp.educorp.microservices.cursos.api.aula4.jwt.repository.CursosRepository;

@RestController
@RequestMapping("/cursos")
public class CursosController {

	@Autowired
	private CursosRepository repository;

	@GetMapping()
	public ResponseEntity<?> getAllCursos() {
		return new ResponseEntity<List<Curso>>(repository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCurso(@PathVariable Integer id) {
		return new ResponseEntity<Curso>(repository.findById(id).get(), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> saveCurso(@RequestBody Curso curso) {
		try {
			return new ResponseEntity<Curso>(repository.save(curso), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Curso>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
