package br.unicamp.educorp.microservices.restaurantes.api.aula8.model;

import java.io.Serializable;
import java.math.BigInteger;
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

import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(name = "tbl_restaurante")
public class Restaurante implements Serializable {

	private static final long serialVersionUID = -5544918869192184020L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "nome", nullable = false, length = 100)
	private String nome;

	@Column(name = "descricao", nullable = false, length = 500)
	private String descricao;

	@Column(name = "cnpj", nullable = false)
	private BigInteger cnpj;

	@Column(name = "faixa_preco", nullable = false)
	@Enumerated(EnumType.STRING)
	private FaixaPreco faixaPreco;

	@Column(name = "cep", nullable = false)
	private Long cep;

	@Column(name = "logradouro", nullable = false, length = 100)
	private String logradouro;

	@Column(name = "numero", nullable = false, length = 10)
	private String numero;

	@Column(name = "complemento", nullable = true, length = 10)
	private String complemento;

	@Column(name = "bairro", nullable = false, length = 100)
	private String bairro;

	@Column(name = "municipio", nullable = false, length = 100)
	private String municipio;

	@Column(name = "estado", nullable = false)
	@Enumerated(EnumType.STRING)
	private Estado estado;

	@Column(name = "pais", nullable = false)
	@Enumerated(EnumType.STRING)
	private Pais pais;

	@Column(name = "categoria", nullable = false)
	private Categoria categoria;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurante")
	private Set<HorarioEntrega> horariosEntrega;

	public Restaurante() {
		super();
	}

	public Restaurante(String nome, String descricao, BigInteger cnpj, FaixaPreco faixaPreco, Long cep,
			String logradouro, String numero, String complemento, String bairro, String municipio, Estado estado,
			Pais pais, Categoria categoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.cnpj = cnpj;
		this.faixaPreco = faixaPreco;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.municipio = municipio;
		this.estado = estado;
		this.pais = pais;
		this.categoria = categoria;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigInteger getCnpj() {
		return cnpj;
	}

	public void setCnpj(BigInteger cnpj) {
		this.cnpj = cnpj;
	}

	public FaixaPreco getFaixaPreco() {
		return faixaPreco;
	}

	public void setFaixaPreco(FaixaPreco faixaPreco) {
		this.faixaPreco = faixaPreco;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<HorarioEntrega> getHorariosEntrega() {
		return horariosEntrega;
	}

	public void setHorariosEntrega(Set<HorarioEntrega> horariosEntrega) {
		this.horariosEntrega = horariosEntrega;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
