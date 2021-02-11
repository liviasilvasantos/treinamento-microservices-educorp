package br.unicamp.educorp.microservices.cursos.api.aula4.model.filter;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FiltroCurso implements Serializable {

	private String codigo;
	private String descricao;
	private int page;
	private int pageSize;

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

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "FiltroCurso [codigo=" + codigo + ", descricao=" + descricao + ", page=" + page + ", pageSize="
				+ pageSize + "]";
	}

}
