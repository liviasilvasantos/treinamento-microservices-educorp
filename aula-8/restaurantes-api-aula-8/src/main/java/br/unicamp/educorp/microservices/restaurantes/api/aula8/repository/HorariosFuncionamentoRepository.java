package br.unicamp.educorp.microservices.restaurantes.api.aula8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.educorp.microservices.restaurantes.api.aula8.model.HorarioFuncionamento;

public interface HorariosFuncionamentoRepository extends JpaRepository<HorarioFuncionamento, Integer> {

}
