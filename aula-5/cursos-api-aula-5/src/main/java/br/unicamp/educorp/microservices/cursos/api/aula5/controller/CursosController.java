package br.unicamp.educorp.microservices.cursos.api.aula5.controller;

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

import br.unicamp.educorp.microservices.cursos.api.aula5.model.Curso;
import br.unicamp.educorp.microservices.cursos.api.aula5.repository.CursosRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

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

	@ApiOperation(value = "Listar cursos", notes = "Listar todos os cursos oferecidos pela Educorp", nickname = "Listar cursos")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Listando todos os cursos", response = Curso.class, responseContainer = "List") })
	@GetMapping("/v6/cursos")
	public ResponseEntity<List<Curso>> getAllCursos() {
		log.info("buscando todos os cursos na porta {}", getHostPorta());
		return new ResponseEntity<List<Curso>>(cursoRepository.findAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "Buscar curso por id", notes = "Buscar o curso oferecido pela Educorp, por id", nickname = "Buscar curso")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Curso encontrado", response = Curso.class),
			@ApiResponse(code = 404, message = "Nenhum curso encontrado") })
	@GetMapping("/v6/cursos/{id}")
	public ResponseEntity<Curso> getCurso(@PathVariable Integer id) {
		log.info("buscando o curso {} na porta {}", id, getHostPorta());

		Optional<Curso> curso = cursoRepository.findById(id);

		if (curso.isPresent()) {
			return new ResponseEntity<Curso>(curso.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
	}

	@ApiOperation(value = "Salvar novo curso", notes = "Salvar um novo curso na Educorp", nickname = "Salvar novo curso")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Novo curso salvo", response = Curso.class),
			@ApiResponse(code = 500, message = "Erro ao salvar novo curso") })
	@PostMapping(value = "/v6/cursos")
	public ResponseEntity<Curso> saveCurso(@RequestBody Curso curso) {
		log.info("salvando novo curso {} na porta {}", curso, getHostPorta());
		try {
			return new ResponseEntity<Curso>(cursoRepository.save(curso), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Curso>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Excluir curso", notes = "Excluir um curso oferecido na Educorp, por id", nickname = "Excluir curso")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "Curso excluído"),
			@ApiResponse(code = 500, message = "Erro ao excluir curso") })
	@DeleteMapping("/v6/cursos/{id}")
	public ResponseEntity<Curso> deleteCurso(@PathVariable Integer id) {
		log.info("excluindo curso {} na porta {}", id, getHostPorta());
		try {
			cursoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return new ResponseEntity<Curso>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@ApiOperation(value = "Alterar curso", notes = "Alterar os dados de um curso, por id", nickname = "Alterar curso")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Curso alterado", response = Curso.class),
			@ApiResponse(code = 404, message = "Curso não encontrado") })
	@PutMapping(value = "/v6/cursos/{id}")
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

	// Versionamento

	@GetMapping(value = "/cursos/p", produces = { "application/vnd.cursos.educorp-v1.0+json" })
	@Deprecated
	public ResponseEntity<String> getCursosMetodoDeprecated() {
		return ResponseEntity.ok("metodo deprecated - buscando todos os cursos");
	}

	@GetMapping(value = "/cursos/p", produces = { "application/vnd.cursos.educorp-v2.0+json" })
	public ResponseEntity<String> getCursosNovoMetodo() {
		return ResponseEntity.ok("metodo novo - buscando todos os cursos");
	}

	@GetMapping(value = "/cursos/h", headers = "API-VERSION=1")
	public ResponseEntity<String> getCursosHeaderVersao1() {
		return ResponseEntity.ok("header versao 1 - buscando todos os cursos");
	}

	@GetMapping(value = "/cursos/h", headers = "API-VERSION=2")
	public ResponseEntity<String> getCursosHeaderVersao2() {
		return ResponseEntity.ok("header versao 2 - buscando todos os cursos");
	}

	@GetMapping(value = "/cursos/v", params = "version=1")
	public ResponseEntity<String> getCursosVersao1() {
		return ResponseEntity.ok("versao 1 - buscando todos os cursos");
	}

	@GetMapping(value = "/cursos/v", params = "version=2")
	public ResponseEntity<String> getCursosVersao2() {
		return ResponseEntity.ok("versao 2 - buscando todos os cursos");
	}

}
