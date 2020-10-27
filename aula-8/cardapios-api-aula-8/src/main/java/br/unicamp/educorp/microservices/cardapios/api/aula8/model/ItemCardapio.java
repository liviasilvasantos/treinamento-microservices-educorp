package br.unicamp.educorp.microservices.cardapios.api.aula8.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_item_cardapio")
public class ItemCardapio implements Serializable {

	private static final long serialVersionUID = -2691915854000376963L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Categoria categoria;

	@Column(name = "titulo", nullable = false, length = 50)
	private String titulo;

	@Column(name = "descricao", nullable = false, length = 300)
	private String descricao;

	@Column(name = "pessoas_por_porcao", nullable = true)
	private Integer pessoasPorPorcao;

	@Column(name = "preco", nullable = false)
	private Double preco;

	@Column(name = "percentual_desconto", nullable = true)
	private Double percentualDesconto;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Cardapio cardapio;

	public ItemCardapio() {
		super();
	}

	public ItemCardapio(Categoria categoria, String titulo, String descricao, Integer pessoasPorPorcao, Double preco,
			Double percentualDesconto, Cardapio cardapio) {
		super();
		this.categoria = categoria;
		this.titulo = titulo;
		this.descricao = descricao;
		this.pessoasPorPorcao = pessoasPorPorcao;
		this.preco = preco;
		this.percentualDesconto = percentualDesconto;
		this.cardapio = cardapio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPessoasPorPorcao() {
		return pessoasPorPorcao;
	}

	public void setPessoasPorPorcao(Integer pessoasPorPorcao) {
		this.pessoasPorPorcao = pessoasPorPorcao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toStringExclude(this, "cardapio");
	}
}
