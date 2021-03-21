package br.unicamp.educorp.microservices.cardapios.api.aula11.model.dto;

public class RestauranteDto {

	private Integer id;
	private String nome;
	private String port;

	public RestauranteDto() {
		super();
	}

	public RestauranteDto(String nome) {
		super();
		this.nome = nome;
	}

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

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "RestauranteDto [id=" + id + ", nome=" + nome + ", port=" + port + "]";
	}

}
