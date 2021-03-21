package br.unicamp.educorp.microservices.cardapios.api.aula11.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import br.unicamp.educorp.microservices.cardapios.api.aula11.model.dto.RestauranteDto;

@Entity
@Table(name = "tbl_cardapio")
public class Cardapio implements Serializable {

	private static final long serialVersionUID = -893583103842522692L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "id_restaurante", nullable = false)
	private Integer idRestaurante;

	@Transient
	private RestauranteDto restaurante;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cardapio")
	private Set<ItemCardapio> itensCardapio;

	public Cardapio() {
		super();
	}

	public Cardapio(Integer idRestaurante, Status status) {
		super();
		this.idRestaurante = idRestaurante;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(Integer idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<ItemCardapio> getItensCardapio() {
		return itensCardapio;
	}

	public void setItensCardapio(Set<ItemCardapio> itensCardapio) {
		this.itensCardapio = itensCardapio;
	}

	public RestauranteDto getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteDto restaurante) {
		this.restaurante = restaurante;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toStringExclude(this, "itensCardapio");
	}
}
