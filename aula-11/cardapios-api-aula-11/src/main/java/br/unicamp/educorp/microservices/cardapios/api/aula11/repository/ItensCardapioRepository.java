package br.unicamp.educorp.microservices.cardapios.api.aula11.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.educorp.microservices.cardapios.api.aula11.model.ItemCardapio;

public interface ItensCardapioRepository extends JpaRepository<ItemCardapio, Integer> {

}
