package br.unicamp.educorp.microservices.cursos.api.aula5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tbl_curso")
@ApiModel(value = "Curso", description = "Curso Oferecido pela Educorp")
public class Curso {

	@ApiModelProperty(value = "id do curso", name = "id", dataType = "int", example = "1")
	@Id
	@Column(name = "id_curso")
	private int id;

	@ApiModelProperty(value = "código do curso", name = "codigo", dataType = "String", example = "MIC")
	@Column(name = "codigo_curso", length = 5, nullable = false)
	private String codigo;

	@ApiModelProperty(value = "descrição do curso", name = "descricao", dataType = "String", example = "Microservices")
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
		return "Curso [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
}
