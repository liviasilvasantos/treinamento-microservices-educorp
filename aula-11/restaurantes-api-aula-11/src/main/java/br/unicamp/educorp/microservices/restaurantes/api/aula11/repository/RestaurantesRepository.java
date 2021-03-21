package br.unicamp.educorp.microservices.restaurantes.api.aula11.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unicamp.educorp.microservices.restaurantes.api.aula11.model.Restaurante;

public interface RestaurantesRepository extends JpaRepository<Restaurante, Integer> {

}
