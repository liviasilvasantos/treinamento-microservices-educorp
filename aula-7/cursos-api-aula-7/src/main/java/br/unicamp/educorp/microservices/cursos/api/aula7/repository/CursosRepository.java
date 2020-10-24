/**
 * 
 */
package br.unicamp.educorp.microservices.cursos.api.aula7.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.educorp.microservices.cursos.api.aula7.model.Curso;

public interface CursosRepository extends JpaRepository<Curso, Integer> {

}