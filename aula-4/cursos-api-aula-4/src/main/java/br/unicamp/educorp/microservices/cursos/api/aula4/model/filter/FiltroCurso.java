package br.unicamp.educorp.microservices.cursos.api.aula4.model.filter;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FiltroCurso implements Serializable {

	private String codigo;
	private String descricao;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "FiltroCurso [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

}
