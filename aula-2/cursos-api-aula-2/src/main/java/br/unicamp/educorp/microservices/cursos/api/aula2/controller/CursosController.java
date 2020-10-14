package br.unicamp.educorp.microservices.cursos.api.aula2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.educorp.microservices.cursos.api.aula2.model.Curso;

@RestController
public class CursosController {

	private List<Curso> getCursosRepository() {
		List<Curso> cursos = new ArrayList<Curso>();

		cursos.add(new Curso(1, "MIC", "Microservices"));
		cursos.add(new Curso(1, "ELK", "ElasticSearch/Logstash/Kibana"));
		cursos.add(new Curso(1, "PYT", "Python"));
		cursos.add(new Curso(1, "BIZ", "Bizagi"));

		return cursos;
	}

	@GetMapping("/v1/cursos")
	public ResponseEntity<String> getAllCursosText() {
		return ResponseEntity.ok("meus cursos: " + getCursosRepository());
	}

	@GetMapping("/v2/cursos")
	public ResponseEntity<List<Curso>> getAllCursos() {
		return new ResponseEntity<List<Curso>>(getCursosRepository(), HttpStatus.OK);
	}

}