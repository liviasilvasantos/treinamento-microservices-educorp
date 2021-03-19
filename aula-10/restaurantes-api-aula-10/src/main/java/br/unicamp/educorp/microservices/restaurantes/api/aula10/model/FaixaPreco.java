package br.unicamp.educorp.microservices.restaurantes.api.aula10.model;

public enum FaixaPreco {

	FAIXA_UM("$"), //
	FAIXA_DOIS("$$"), //
	FAIXA_TRES("$$$"), //
	FAIXA_QUATRO("$$$$"), //
	FAIXA_CINCO("$$$$$");

	private String descricao;

	private FaixaPreco(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
