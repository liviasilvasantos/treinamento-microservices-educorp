package br.unicamp.educorp.microservices.restaurantes.api.aula11.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unicamp.educorp.microservices.restaurantes.api.aula11.exception.RestauranteNaoEncontradoException;
import br.unicamp.educorp.microservices.restaurantes.api.aula11.model.Restaurante;
import br.unicamp.educorp.microservices.restaurantes.api.aula11.repository.RestaurantesRepository;
import br.unicamp.educorp.microservices.restaurantes.api.aula11.service.RestaurantesService;

@Service
public class RestaurantesServiceImpl implements RestaurantesService {

	@Autowired
	private RestaurantesRepository restaurantesRepository;

	@Override
	public List<Restaurante> buscarRestaurantes() {
		return restaurantesRepository.findAll();
	}

	@Override
	public Restaurante buscarRestaurante(Integer id) throws RestauranteNaoEncontradoException {
		Optional<Restaurante> restaurante = restaurantesRepository.findById(id);
		return restaurante.orElseThrow(
				() -> new RestauranteNaoEncontradoException("Nenhum restaurante encontrado com o id [" + id + "]"));
	}

	@Override
	public Restaurante salvarRestaurante(Restaurante restaurante) throws RestauranteNaoEncontradoException {
		if (restaurante.getId() != null) {
			if (!restaurantesRepository.existsById(restaurante.getId())) {
				throw new RestauranteNaoEncontradoException(
						"Nenhum restaurante encontrado com o id [" + restaurante.getId() + "]");
			}
		}
		return restaurantesRepository.save(restaurante);
	}

	@Override
	public void excluirRestaurante(Integer id) throws RestauranteNaoEncontradoException {
		if (!restaurantesRepository.existsById(id)) {
			throw new RestauranteNaoEncontradoException("Nenhum restaurante encontrado com o id [" + id + "]");
		}
		restaurantesRepository.deleteById(id);
	}

}
