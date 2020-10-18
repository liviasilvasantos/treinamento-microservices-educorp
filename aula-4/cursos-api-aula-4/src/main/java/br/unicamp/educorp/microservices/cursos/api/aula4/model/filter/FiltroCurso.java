package br.unicamp.educorp.microservices.cursos.api.aula4.model.filter;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FiltroCurso implements Serializable {

	private String codigo;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "FiltroCurso [codigo=" + codigo + "]";
	}

}
