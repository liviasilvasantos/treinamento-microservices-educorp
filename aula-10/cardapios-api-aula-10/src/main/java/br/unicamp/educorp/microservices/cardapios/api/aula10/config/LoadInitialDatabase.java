package br.unicamp.educorp.microservices.cardapios.api.aula10.config;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.unicamp.educorp.microservices.cardapios.api.aula10.model.Cardapio;
import br.unicamp.educorp.microservices.cardapios.api.aula10.model.Categoria;
import br.unicamp.educorp.microservices.cardapios.api.aula10.model.ItemCardapio;
import br.unicamp.educorp.microservices.cardapios.api.aula10.model.Status;
import br.unicamp.educorp.microservices.cardapios.api.aula10.repository.CardapiosRepository;
import br.unicamp.educorp.microservices.cardapios.api.aula10.repository.CategoriasRepository;
import br.unicamp.educorp.microservices.cardapios.api.aula10.repository.ItensCardapioRepository;

@Configuration
public class LoadInitialDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadInitialDatabase.class);

	@Bean
	public CommandLineRunner initialDatabase(CardapiosRepository cardapiosRepository,
			ItensCardapioRepository itensCardapioRepository, CategoriasRepository categoriasRepository) {
		return args -> {

			// veg wrap = 1
			Categoria c1 = new Categoria("Double wrap");
			Categoria c2 = new Categoria("Combos");

			categoriasRepository.saveAll(Stream.of(c1, c2).collect(Collectors.toList()));

			Cardapio cardapioVegWrap = new Cardapio(1, Status.ATIVO);
			cardapioVegWrap = cardapiosRepository.save(cardapioVegWrap);

			ItemCardapio i1 = new ItemCardapio(c1, "Double Big Margherita",
					"2 Wraps Grandes Margherita com o dobro de recheio de mix de queijos, tomate e pesto de manjericão, e com a deliciosa crosta d eparmesão no pão inteiro",
					2, Double.valueOf(35.00), null, cardapioVegWrap);
			ItemCardapio i2 = new ItemCardapio(c1, "Double falafel (grande)", "Dois wraps grandes de falafel", 2,
					Double.valueOf(45.00), null, cardapioVegWrap);

			ItemCardapio i3 = new ItemCardapio(c2, "Combo falafel grande 2 pessoas",
					"2 wraps de falafel grandes + 1 porção de 12 unid de falafel + 2 chás", null, Double.valueOf(64.90),
					null, cardapioVegWrap);
			ItemCardapio i4 = new ItemCardapio(c2, "Combo margueritta grande 2 pessoas",
					"2 Margueritta grande + 1 porção de 12 unid de falafel + 2 chás", null, Double.valueOf(59.90), null,
					cardapioVegWrap);

			itensCardapioRepository.saveAll(Stream.of(i1, i2, i3, i4).collect(Collectors.toList()));

			log.info("Carregando " + cardapioVegWrap);

			// outback =2

			Categoria c3 = new Categoria("Aperitivos");
			Categoria c4 = new Categoria("Massas");
			Categoria c5 = new Categoria("Steaks");

			categoriasRepository.saveAll(Stream.of(c3, c4, c5).collect(Collectors.toList()));

			Cardapio cardapioOutback = new Cardapio(2, Status.ATIVO);
			cardapioOutback = cardapiosRepository.save(cardapioOutback);

			ItemCardapio i5 = new ItemCardapio(c3, "Aussie beef quesadillas",
					"Pétalas de bloomin onion, tiras de filet mignon, mix de queijos e tomate. Tudo dentro de saborosas quesadillas, acompanhas do molho bloom.",
					null, Double.valueOf(57.50), null, cardapioOutback);
			ItemCardapio i6 = new ItemCardapio(c3, "Ridgy didgy mini burgers",
					"Seis mini burgers com queijo especial, ketchup, mostarda, picles e cebola roxa", null,
					Double.valueOf(57.50), null, cardapioOutback);

			ItemCardapio i7 = new ItemCardapio(c4, "Toowoomba pasta",
					"Uma mistura caprichada de camarões e champignons, temperada com ervas finas e servida com fettucine refogado ao molho alfredo. Escolha entre o tempero suave ou intenso.",
					null, Double.valueOf(56.50), null, cardapioOutback);

			ItemCardapio i8 = new ItemCardapio(c5, "Herb crusted filet",
					"São 170g de filet mignon em três cortes, temperados com ervas finas, servidos com molho Cabernet Merlot. File preparado em Ponto para Mal Passado, com centro avermelhado e morno",
					null, Double.valueOf(66.90), null, cardapioOutback);

			itensCardapioRepository.saveAll(Stream.of(i5, i6, i7, i8).collect(Collectors.toList()));

			log.info("Carregando " + cardapioOutback);

			// abigail = 3

			Categoria c6 = new Categoria("Bebidas quentes");
			Categoria c7 = new Categoria("Bebidas geladas");

			categoriasRepository.saveAll(Stream.of(c6, c7).collect(Collectors.toList()));

			Cardapio cardapioAbigail = new Cardapio(3, Status.ATIVO);
			cardapioAbigail = cardapiosRepository.save(cardapioAbigail);

			ItemCardapio i9 = new ItemCardapio(c6, "Café coado da casa - SUNDROP - 180ml",
					"Sensorial: Encorpado, frutas cítricas maduras, maçã e floral. Importante, o café pode perder temperatura durante a viagem.",
					null, Double.valueOf(15.00), null, cardapioAbigail);
			ItemCardapio i10 = new ItemCardapio(c6, "Chocolate Quente Belga - 180ml",
					"Chocolate quente produzido com chocolate Belga Callebaut, especiarias secretas da casa, leite fresco de qualidade. Cremoso e irresistível.",
					null, Double.valueOf(20.00), null, cardapioAbigail);

			ItemCardapio i11 = new ItemCardapio(c7, "Freddo abigail",
					"Direto da Grécia para a Abigail, espresso duplo emulsionado com gelo. Cremoso e refrescante.",
					null, Double.valueOf(14.00), null, cardapioAbigail);
			ItemCardapio i12 = new ItemCardapio(c7, "Chocolate gelado",
					"Chocolate gelado produzido com chocolate belga callebaut, especiarias secretas da casa, leite fresco de qualidade. Cremoso e irresistível.",
					null, Double.valueOf(20.00), null, cardapioAbigail);

			itensCardapioRepository.saveAll(Stream.of(i9, i10, i11, i12).collect(Collectors.toList()));

			log.info("Carregando " + cardapioAbigail);

		};
	}
}
