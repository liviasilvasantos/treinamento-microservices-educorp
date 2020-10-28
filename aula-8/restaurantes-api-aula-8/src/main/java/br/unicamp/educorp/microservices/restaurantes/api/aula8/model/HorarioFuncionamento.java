/**
 * 
 */
package br.unicamp.educorp.microservices.restaurantes.api.aula8.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_horario_funcionamento")
public class HorarioFuncionamento implements Serializable {

	private static final long serialVersionUID = -7352458149835363617L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;

	@Column(name = "dia_semana", nullable = false)
	@Enumerated(EnumType.STRING)
	private DiaSemana diaSemana;

	@Column(name = "horario_inicio", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioInicio;

	@Column(name = "horario_fim", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date horarioFim;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Restaurante restaurante;

	public HorarioFuncionamento() {
		super();
	}

	public HorarioFuncionamento(DiaSemana diaSemana, Date horarioInicio, Date horarioFim, Restaurante restaurante) {
		super();
		this.diaSemana = diaSemana;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.restaurante = restaurante;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toStringExclude(this, "restaurante");
	}
}
