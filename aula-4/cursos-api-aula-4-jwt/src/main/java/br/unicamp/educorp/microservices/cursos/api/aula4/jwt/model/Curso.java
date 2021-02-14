package br.unicamp.educorp.microservices.cursos.api.aula4.jwt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_curso")
public class Curso {

	@Id
	@Column(name = "id_curso")
	private int id;

	@Column(name = "codigo_curso", length = 5, nullable = false)
	private String codigo;

	@Column(name = "descricao_curso", length = 250, nullable = false)
	private String descricao;

	public Curso() {
		super();
	}

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
		return "Curso [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + "]";
	}

}
