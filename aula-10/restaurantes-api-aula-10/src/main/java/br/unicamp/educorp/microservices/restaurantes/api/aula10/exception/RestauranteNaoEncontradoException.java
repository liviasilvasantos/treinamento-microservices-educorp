package br.unicamp.educorp.microservices.restaurantes.api.aula10.exception;

public class RestauranteNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1580910112536234548L;

	public RestauranteNaoEncontradoException() {
		super();
	}

	public RestauranteNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public RestauranteNaoEncontradoException(String message) {
		super(message);
	}

	public RestauranteNaoEncontradoException(Throwable cause) {
		super(cause);
	}

}
