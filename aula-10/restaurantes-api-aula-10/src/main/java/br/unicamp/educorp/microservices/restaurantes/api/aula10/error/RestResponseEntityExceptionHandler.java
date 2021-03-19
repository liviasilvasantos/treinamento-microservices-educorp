package br.unicamp.educorp.microservices.restaurantes.api.aula10.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.unicamp.educorp.microservices.restaurantes.api.aula10.error.model.ErrorMessage;
import br.unicamp.educorp.microservices.restaurantes.api.aula10.exception.RestauranteNaoEncontradoException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { RestauranteNaoEncontradoException.class })
	protected ResponseEntity<ErrorMessage> handleNotFound(RestauranteNaoEncontradoException ex,
			HttpServletRequest request) {
		String mensagem = ex.getLocalizedMessage();

		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), //
				HttpStatus.NOT_FOUND.name(), //
				mensagem, //
				request.getRequestURI());

		return new ResponseEntity<ErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
	}
}
