package br.unicamp.educorp.microservices.cardapios.api.aula10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.educorp.microservices.cardapios.api.aula10.model.ItemCardapio;

public interface ItensCardapioRepository extends JpaRepository<ItemCardapio, Integer> {

}
