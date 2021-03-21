package br.unicamp.educorp.microservices.cardapios.api.aula11.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.educorp.microservices.cardapios.api.aula11.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
