package br.unicamp.educorp.microservices.cursos.api.aula5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.educorp.microservices.cursos.api.aula5.model.Curso;

public interface CursosRepository extends JpaRepository<Curso, Integer> {

}
