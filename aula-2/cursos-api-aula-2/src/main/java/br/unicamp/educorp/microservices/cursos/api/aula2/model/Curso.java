package br.unicamp.educorp.microservices.cursos.api.aula2.model;

public class Curso {

	private int id;
	private String codigo;
	private String descricao;

	public Curso(int id, String codigo, String descricao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		return "Curso [codigo=" + codigo + ", descricao=" + descricao + "]";
	}

}
