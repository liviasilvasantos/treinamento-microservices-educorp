package br.unicamp.educorp.microservices.cursos.api.aula4.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.educorp.microservices.cursos.api.aula4.jwt.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
