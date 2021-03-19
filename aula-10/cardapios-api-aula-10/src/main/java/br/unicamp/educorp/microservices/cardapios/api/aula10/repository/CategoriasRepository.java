package br.unicamp.educorp.microservices.cardapios.api.aula10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.educorp.microservices.cardapios.api.aula10.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

}
