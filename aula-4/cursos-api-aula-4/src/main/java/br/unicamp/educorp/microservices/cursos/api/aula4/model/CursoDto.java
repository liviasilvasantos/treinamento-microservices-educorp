package br.unicamp.educorp.microservices.cursos.api.aula4.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class CursoDto implements Serializable {

	private Integer identification;

	private String code;

	private String description;

	public CursoDto() {
		super();
	}

	public Integer getIdentification() {
		return identification;
	}

	public void setIdentification(Integer identification) {
		this.identification = identification;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CursoDto [code=" + code + ", description=" + description + "]";
	}
}
