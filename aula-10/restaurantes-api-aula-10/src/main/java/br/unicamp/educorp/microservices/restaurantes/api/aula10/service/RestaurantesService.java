package br.unicamp.educorp.microservices.restaurantes.api.aula10.service;

import java.util.List;

import br.unicamp.educorp.microservices.restaurantes.api.aula10.exception.RestauranteNaoEncontradoException;
import br.unicamp.educorp.microservices.restaurantes.api.aula10.model.Restaurante;

public interface RestaurantesService {

	List<Restaurante> buscarRestaurantes();

	Restaurante buscarRestaurante(Integer id) throws RestauranteNaoEncontradoException;

	Restaurante salvarRestaurante(Restaurante restaurante) throws RestauranteNaoEncontradoException;

	void excluirRestaurante(Integer id) throws RestauranteNaoEncontradoException;
}
