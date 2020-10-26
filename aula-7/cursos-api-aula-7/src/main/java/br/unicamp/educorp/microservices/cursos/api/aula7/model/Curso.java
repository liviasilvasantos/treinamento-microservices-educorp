package br.unicamp.educorp.microservices.cursos.api.aula7.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@SuppressWarnings("serial")
@Entity
@Table(name = "tbl_curso")
public class Curso implements Serializable {

	@Id
	@Column(name = "id_curso")
	private Integer id;

	@Column(name = "codigo_curso", length = 5, nullable = false)
	@NotBlank(message = "Campo Código é obrigatório")
	@Length(min = 3, max = 5, message = "Campo Código deve ter entre 3 e 5 caracteres")
	private String codigo;

	@Column(name = "descricao_curso", length = 250, nullable = false)
	@NotBlank(message = "Campo Descrição obrigatório")
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
