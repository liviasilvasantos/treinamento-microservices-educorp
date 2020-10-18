package br.unicamp.educorp.microservices.cursos.api.aula4.mapping;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public interface CursoPOJOMixin {

	@JsonProperty("descricaoDoCurso")
	String getDescricao();

	@JsonIgnore
	Date getDataInicio();
}
