package br.unicamp.educorp.microservices.cursos.api.aula4.mapping;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class CursoPOJO implements Serializable {

	private Integer id;
	private String codigo;
	private String descricao;
	private Date dataInicio;

	public CursoPOJO() {
		super();
	}

	public CursoPOJO(Integer id, String codigo, String descricao) {
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Override
	public String toString() {
		return "CursoPOJO [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", dataInicio=" + dataInicio
				+ "]";
	}
}
