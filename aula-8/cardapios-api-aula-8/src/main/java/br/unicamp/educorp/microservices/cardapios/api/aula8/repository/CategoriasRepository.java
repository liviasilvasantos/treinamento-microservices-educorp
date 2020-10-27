package br.unicamp.educorp.microservices.cardapios.api.aula8.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.educorp.microservices.cardapios.api.aula8.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
