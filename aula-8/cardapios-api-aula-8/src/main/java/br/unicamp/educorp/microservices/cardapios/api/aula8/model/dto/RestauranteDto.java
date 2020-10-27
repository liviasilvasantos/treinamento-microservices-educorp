package br.unicamp.educorp.microservices.cardapios.api.aula8.model.dto;

public class RestauranteDto {

	private Integer id;
	private String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "RestauranteDto [id=" + id + ", nome=" + nome + "]";
	}
}
