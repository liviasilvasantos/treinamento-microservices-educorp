package br.unicamp.educorp.microservices.cursos.api.aula7.exception;

@SuppressWarnings("serial")
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CursoNaoEncontradoException extends RuntimeException {

	public CursoNaoEncontradoException() {
		super();
	}

	public CursoNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CursoNaoEncontradoException(String message) {
		super(message);
	}

	public CursoNaoEncontradoException(Throwable cause) {
		super(cause);
	}

}
