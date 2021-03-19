package br.unicamp.educorp.microservices.restaurantes.api.aula10.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.educorp.microservices.restaurantes.api.aula10.model.Restaurante;

public interface RestaurantesRepository extends JpaRepository<Restaurante, Integer> {

}
