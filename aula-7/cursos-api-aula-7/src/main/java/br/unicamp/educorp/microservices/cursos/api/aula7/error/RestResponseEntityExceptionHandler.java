package br.unicamp.educorp.microservices.cursos.api.aula7.error;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.unicamp.educorp.microservices.cursos.api.aula7.error.model.ErrorMessage;
import br.unicamp.educorp.microservices.cursos.api.aula7.exception.CursoNaoEncontradoException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

//	@ExceptionHandler(value = { CursoNaoEncontradoException.class })
//	protected ResponseEntity<Object> handleNotFound(CursoNaoEncontradoException ex, WebRequest request) {
//		String bodyOfResponse = ex.getLocalizedMessage();
//		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
//	}

	@ExceptionHandler(value = { CursoNaoEncontradoException.class })
	protected ResponseEntity<ErrorMessage> handleNotFound(CursoNaoEncontradoException ex, HttpServletRequest request) {
		String bodyOfResponse = "Erro encontrado: " + ex.getLocalizedMessage();

		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), //
				HttpStatus.NOT_FOUND.name(), //
				bodyOfResponse, //
				request.getRequestURI());

		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}

	// precisa sobrescrever porque o handler principal já tem um método para isso
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), //
				HttpStatus.BAD_REQUEST.name(), //
				errors.toString(), //
				request.getDescription(false));

		return new ResponseEntity<Object>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<ErrorMessage> handleConstraintViolationException(ConstraintViolationException e,
			HttpServletRequest request) {

		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.BAD_REQUEST.value(), //
				HttpStatus.BAD_REQUEST.name(), //
				e.getLocalizedMessage(), //
				request.getRequestURI());

		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.BAD_REQUEST);
	}
}
