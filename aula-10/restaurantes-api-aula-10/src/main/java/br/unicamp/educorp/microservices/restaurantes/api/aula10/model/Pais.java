package br.unicamp.educorp.microservices.restaurantes.api.aula10.model;

public enum Pais {

	BR("Brasil"), //
	AR("Argentina"), //
	UY("Uruguai"), //
	EC("Equador"), //
	PY("Paraguai"), //
	CL("Chile"), //
	PE("Peru"), //
	CO("Colombia"), //
	VE("Venezuela");

	private final String nome;

	private Pais(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
