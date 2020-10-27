package br.unicamp.educorp.microservices.cardapios.api.aula8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.unicamp.educorp.microservices.cardapios.api.aula8.model.Cardapio;

public interface CardapiosRepository extends JpaRepository<Cardapio, Integer> {

	@Query("select c from Cardapio c inner join fetch c.itensCardapio i inner join fetch i.categoria cat order by c.id ")
	List<Cardapio> buscarTodosCardapiosComItens();
}
