package br.unicamp.educorp.microservices.cursos.api.aula7.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Max;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.unicamp.educorp.microservices.cursos.api.aula7.exception.CursoNaoEncontradoException;
import br.unicamp.educorp.microservices.cursos.api.aula7.model.Curso;
import br.unicamp.educorp.microservices.cursos.api.aula7.repository.CursosRepository;

@RestController
@Validated
public class CursosExceptionController {

	private static final Logger log = LoggerFactory.getLogger(CursosExceptionController.class);

	@Autowired
	private CursosRepository cursoRepository;

	@Autowired
	private Environment environment;

	private String getHostPorta() {
		return environment.getProperty("local.server.port");
	}

	// Tratamento de Excecoes

	@GetMapping("/v8/cursos/{id}")
	public ResponseEntity<Curso> getCurso(@PathVariable Integer id) {
		log.info("buscando o curso {} na porta {}", id, getHostPorta());

		Optional<Curso> curso = cursoRepository.findById(id);

		if (curso.isPresent()) {
			return new ResponseEntity<Curso>(curso.get(), HttpStatus.OK);
		} else {
			throw new CursoNaoEncontradoException("Nenhum curso encontrado para o id [" + id + "]");

			// throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhum curso
			// encontrado para o id [" + id + "]");

			// return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping(value = "/v8/cursos")
	public ResponseEntity<Curso> saveCurso(@Valid @RequestBody Curso curso) {
		log.info("salvando novo curso {} na porta {}", curso, getHostPorta());
		try {
			return new ResponseEntity<Curso>(cursoRepository.save(curso), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Curso>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// métodos foram movidos para o ControllerAdvice
	// @ExceptionHandler(MethodArgumentNotValidException.class)
	// @ResponseStatus(HttpStatus.BAD_REQUEST)
	// public Map<String, String>
	// handleValidationExceptions(MethodArgumentNotValidException ex) {
	// Map<String, String> errors = new HashMap<>();
	// ex.getBindingResult().getAllErrors().forEach((error) -> {
	// String fieldName = ((FieldError) error).getField();
	// String errorMessage = error.getDefaultMessage();
	// errors.put(fieldName, errorMessage);
	// });
	// return errors;
	// }
	//
	// @ExceptionHandler(ConstraintViolationException.class)
	// @ResponseStatus(HttpStatus.BAD_REQUEST)
	// ResponseEntity<String>
	// handleConstraintViolationException(ConstraintViolationException e) {
	// return new ResponseEntity<>("ocorreu um erro: " + e.getMessage(),
	// HttpStatus.BAD_REQUEST);
	// }
}
