package br.unicamp.educorp.microservices.cursos.api.aula4.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.educorp.microservices.cursos.api.aula4.model.Curso;
import br.unicamp.educorp.microservices.cursos.api.aula4.model.filter.FiltroCurso;
import br.unicamp.educorp.microservices.cursos.api.aula4.repository.CursosRepository;

@RestController
public class CursosController {

	private static final Logger log = LoggerFactory.getLogger(CursosController.class);

	@Autowired
	private CursosRepository cursoRepository;

	@Autowired
	private Environment environment;

	private String getHostPorta() {
		return environment.getProperty("local.server.port");
	}

	@GetMapping("/v3/cursos")
	public ResponseEntity<List<Curso>> getAllCursos() {
		log.info("buscando todos os cursos na porta {}", getHostPorta());
		return new ResponseEntity<List<Curso>>(cursoRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/v3/cursos/{id}")
	public ResponseEntity<Curso> getCurso(@PathVariable Integer id) {
		log.info("buscando o curso {} na porta {}", id, getHostPorta());
		return new ResponseEntity<Curso>(cursoRepository.findById(id).get(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/v3/cursos")
	public ResponseEntity<Curso> saveCurso(@RequestBody Curso curso) {
		log.info("salvando novo curso {} na porta {}", curso, getHostPorta());
		try {
			return new ResponseEntity<Curso>(cursoRepository.save(curso), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Curso>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/v3/cursos/{id}")
	public ResponseEntity<Curso> deleteCurso(@PathVariable Integer id) {
		log.info("excluindo curso {} na porta {}", id, getHostPorta());
		try {
			cursoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return new ResponseEntity<Curso>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(value = "/v3/cursos/{id}")
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
	
	@PostMapping(value = "/v3/cursos/filter")
	public ResponseEntity<List<Curso>> getCursoByFilter(@RequestBody FiltroCurso filtro) {
		log.info("buscando o curso com filtro {} na porta {}", filtro, getHostPorta());

		List<Curso> cursos = cursoRepository.findAllByCodigoContains(filtro.getCodigo());

		if (cursos == null || cursos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
	}

	@GetMapping("/v4/cursos/hateoas/{id}")
	public ResponseEntity<EntityModel<Curso>> getCursoHateoas(@PathVariable Integer id) {
		log.info("buscando o curso hateoas {} na porta {}", id, getHostPorta());

		Optional<Curso> curso = cursoRepository.findById(id);

		if (curso.isPresent()) {
			EntityModel<Curso> model = EntityModel.of(curso.get(), //
					linkTo(methodOn(CursosController.class).getCurso(id)).withSelfRel(),
					linkTo(methodOn(CursosController.class).getAllCursos()).withRel("all"));

			return ResponseEntity.ok(model);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/v4/cursos/hateoas")
	public ResponseEntity<List<EntityModel<Curso>>> getAllCursoHateoas() {
		log.info("buscando todos os curso hateoas na porta {}", getHostPorta());

		List<EntityModel<Curso>> cursosModel = new ArrayList<EntityModel<Curso>>();
		List<Curso> cursos = cursoRepository.findAll();

		for (Curso c : cursos) {
			cursosModel.add(EntityModel.of(c, //
					linkTo(methodOn(CursosController.class).getCurso(c.getId())).withSelfRel(),
					linkTo(methodOn(CursosController.class).getAllCursos()).withRel("all")));
		}

		return new ResponseEntity<List<EntityModel<Curso>>>(cursosModel, HttpStatus.OK);
	}
}
