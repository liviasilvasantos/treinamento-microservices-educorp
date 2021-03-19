package br.unicamp.educorp.microservices.cardapios.api.aula10.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.unicamp.educorp.microservices.cardapios.api.aula10.model.Cardapio;

public interface CardapiosRepository extends JpaRepository<Cardapio, Integer> {

	@Query("select distinct c from Cardapio c inner join fetch c.itensCardapio i inner join fetch i.categoria cat order by c.id ")
	List<Cardapio> buscarTodosCardapiosComItens();

	@Query("select c from Cardapio c inner join fetch c.itensCardapio i inner join fetch i.categoria cat where c.id = :id ")
	Optional<Cardapio> buscarCardapioComItens(@Param("id") Integer id);
}
