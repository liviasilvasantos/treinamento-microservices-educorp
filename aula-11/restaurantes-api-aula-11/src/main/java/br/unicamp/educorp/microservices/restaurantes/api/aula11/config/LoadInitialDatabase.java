package br.unicamp.educorp.microservices.restaurantes.api.aula11.config;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.unicamp.educorp.microservices.restaurantes.api.aula11.model.Categoria;
import br.unicamp.educorp.microservices.restaurantes.api.aula11.model.DiaSemana;
import br.unicamp.educorp.microservices.restaurantes.api.aula11.model.Estado;
import br.unicamp.educorp.microservices.restaurantes.api.aula11.model.FaixaPreco;
import br.unicamp.educorp.microservices.restaurantes.api.aula11.model.HorarioFuncionamento;
import br.unicamp.educorp.microservices.restaurantes.api.aula11.model.Pais;
import br.unicamp.educorp.microservices.restaurantes.api.aula11.model.Restaurante;
import br.unicamp.educorp.microservices.restaurantes.api.aula11.repository.HorariosFuncionamentoRepository;
import br.unicamp.educorp.microservices.restaurantes.api.aula11.repository.RestaurantesRepository;

@Configuration
public class LoadInitialDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadInitialDatabase.class);

	private static final String HORARIO_PATTERN = "HH:mm";

	@Bean
	public CommandLineRunner initialDatabase(RestaurantesRepository restaurantesRepository,
			HorariosFuncionamentoRepository horariosEntregaRepository) {
		return args -> {

			Restaurante vegWrap = new Restaurante("Veg Wrap Fresh Food", //
					"A Veg Wrap - Fresh Food, um restaurante especializado em gastronomia vegana, vegetariana e saudável. Oferecendo produtos novos, artesanais e exclusivos, inspirando hábitos alimentares mais naturais e saudáveis, promovendo uma maior consciência.", //
					BigInteger.valueOf(33124410000101L), //
					FaixaPreco.FAIXA_DOIS, //
					13083830L, //
					"Av Professor Atílio Martini", //
					"190", //
					null, //
					"Cidade Universitária", //
					"Campinas", Estado.SP, Pais.BR, Categoria.VEGETARIANA);
			vegWrap = restaurantesRepository.save(vegWrap);

			HorarioFuncionamento vegWrapH1 = new HorarioFuncionamento(DiaSemana.DOMINGO,
					DateUtils.parseDate("18:30", HORARIO_PATTERN), DateUtils.parseDate("23:00", HORARIO_PATTERN),
					vegWrap);
			HorarioFuncionamento vegWrapH2 = new HorarioFuncionamento(DiaSemana.SEGUNDA,
					DateUtils.parseDate("18:30", HORARIO_PATTERN), DateUtils.parseDate("23:00", HORARIO_PATTERN),
					vegWrap);
			HorarioFuncionamento vegWrapH3 = new HorarioFuncionamento(DiaSemana.TERCA,
					DateUtils.parseDate("18:30", HORARIO_PATTERN), DateUtils.parseDate("23:00", HORARIO_PATTERN),
					vegWrap);
			HorarioFuncionamento vegWrapH4 = new HorarioFuncionamento(DiaSemana.QUARTA,
					DateUtils.parseDate("18:30", HORARIO_PATTERN), DateUtils.parseDate("23:00", HORARIO_PATTERN),
					vegWrap);
			HorarioFuncionamento vegWrapH5 = new HorarioFuncionamento(DiaSemana.QUINTA,
					DateUtils.parseDate("18:30", HORARIO_PATTERN), DateUtils.parseDate("23:00", HORARIO_PATTERN),
					vegWrap);
			HorarioFuncionamento vegWrapH6 = new HorarioFuncionamento(DiaSemana.SEXTA,
					DateUtils.parseDate("18:30", HORARIO_PATTERN), DateUtils.parseDate("23:00", HORARIO_PATTERN),
					vegWrap);
			HorarioFuncionamento vegWrapH7 = new HorarioFuncionamento(DiaSemana.SABADO,
					DateUtils.parseDate("18:30", HORARIO_PATTERN), DateUtils.parseDate("23:00", HORARIO_PATTERN),
					vegWrap);

			horariosEntregaRepository
					.saveAll(Stream.of(vegWrapH1, vegWrapH2, vegWrapH3, vegWrapH4, vegWrapH5, vegWrapH6, vegWrapH7)
							.collect(Collectors.toList()));

			log.info("Carregando " + vegWrap);

			Restaurante outback = new Restaurante("Outback Parque D. Pedro Shopping", //
					"Sejam bem-vindos a uma viagem de descobertas pela Austrália e seus sabores marcantes. Aqui no Outback, a única regra é aproveitar cada momento, seja onde você estiver. Aproveite para conhecer nosso cardápio com opções de aperitivos, steaks, nossa tradicional Ribs on the Barbie, massas, hambúrgueres, frangos, peixes e pratos vegetarianos. Aproveite!", //
					BigInteger.valueOf(43828432000106L), //
					FaixaPreco.FAIXA_TRES, //
					13087970L, //
					"Av. Guilherme Campos", //
					"500", //
					"Loja 004 A", //
					"Parque das Flores ", //
					"Campinas", Estado.SP, Pais.BR, Categoria.CARNES);
			outback = restaurantesRepository.save(outback);

			HorarioFuncionamento outbackH1 = new HorarioFuncionamento(DiaSemana.DOMINGO,
					DateUtils.parseDate("11:00", HORARIO_PATTERN), DateUtils.parseDate("22:00", HORARIO_PATTERN),
					outback);
			HorarioFuncionamento outbackH2 = new HorarioFuncionamento(DiaSemana.SEGUNDA,
					DateUtils.parseDate("11:00", HORARIO_PATTERN), DateUtils.parseDate("22:00", HORARIO_PATTERN),
					outback);
			HorarioFuncionamento outbackH3 = new HorarioFuncionamento(DiaSemana.TERCA,
					DateUtils.parseDate("11:00", HORARIO_PATTERN), DateUtils.parseDate("22:00", HORARIO_PATTERN),
					outback);
			HorarioFuncionamento outbackH4 = new HorarioFuncionamento(DiaSemana.QUARTA,
					DateUtils.parseDate("11:00", HORARIO_PATTERN), DateUtils.parseDate("22:00", HORARIO_PATTERN),
					outback);
			HorarioFuncionamento outbackH5 = new HorarioFuncionamento(DiaSemana.QUINTA,
					DateUtils.parseDate("11:00", HORARIO_PATTERN), DateUtils.parseDate("22:00", HORARIO_PATTERN),
					outback);
			HorarioFuncionamento outbackH6 = new HorarioFuncionamento(DiaSemana.SEXTA,
					DateUtils.parseDate("11:00", HORARIO_PATTERN), DateUtils.parseDate("22:00", HORARIO_PATTERN),
					outback);
			HorarioFuncionamento outbackH7 = new HorarioFuncionamento(DiaSemana.SABADO,
					DateUtils.parseDate("11:00", HORARIO_PATTERN), DateUtils.parseDate("22:00", HORARIO_PATTERN),
					outback);

			horariosEntregaRepository
					.saveAll(Stream.of(outbackH1, outbackH2, outbackH3, outbackH4, outbackH5, outbackH6, outbackH7)
							.collect(Collectors.toList()));

			log.info("Carregando " + outback);

			Restaurante abigail = new Restaurante("Abigail Coffee Company", //
					"Nossos cafés são torrados com perfeição por nossos amigos da @nossacasacafe! Isso significa que nossos grãos são torrados mais clarinhos e com toda a técnica para destacar seus sabores e nuances, ao invés de escondê-los ou “queimar” o café durante a torra. Isso tudo faz com que nosso espresso seja naturalmente mais doce que a maioria dos que a gente encontra por aí. Bom, agora a gente vai ali tirar um espresso rapidinho e já volta. A gente espera vocês aqui na Abigail!", //
					BigInteger.valueOf(21626060000194L), //
					FaixaPreco.FAIXA_UM, //
					13024000L, //
					"Av. Cel. Silva Telles", //
					"165", //
					null, //
					"Cambuí", //
					"Campinas", Estado.SP, Pais.BR, Categoria.CAFETERIAS);
			abigail = restaurantesRepository.save(abigail);

			HorarioFuncionamento abigailH1 = new HorarioFuncionamento(DiaSemana.DOMINGO,
					DateUtils.parseDate("09:00", HORARIO_PATTERN), DateUtils.parseDate("15:00", HORARIO_PATTERN),
					abigail);
			HorarioFuncionamento abigailH2 = new HorarioFuncionamento(DiaSemana.SEGUNDA,
					DateUtils.parseDate("09:00", HORARIO_PATTERN), DateUtils.parseDate("18:00", HORARIO_PATTERN),
					abigail);
			HorarioFuncionamento abigailH3 = new HorarioFuncionamento(DiaSemana.TERCA,
					DateUtils.parseDate("09:00", HORARIO_PATTERN), DateUtils.parseDate("18:00", HORARIO_PATTERN),
					abigail);
			HorarioFuncionamento abigailH4 = new HorarioFuncionamento(DiaSemana.QUARTA,
					DateUtils.parseDate("09:00", HORARIO_PATTERN), DateUtils.parseDate("18:00", HORARIO_PATTERN),
					abigail);
			HorarioFuncionamento abigailH5 = new HorarioFuncionamento(DiaSemana.QUINTA,
					DateUtils.parseDate("09:00", HORARIO_PATTERN), DateUtils.parseDate("18:00", HORARIO_PATTERN),
					abigail);
			HorarioFuncionamento abigailH6 = new HorarioFuncionamento(DiaSemana.SEXTA,
					DateUtils.parseDate("09:00", HORARIO_PATTERN), DateUtils.parseDate("18:00", HORARIO_PATTERN),
					abigail);
			HorarioFuncionamento abigailH7 = new HorarioFuncionamento(DiaSemana.SABADO,
					DateUtils.parseDate("09:00", HORARIO_PATTERN), DateUtils.parseDate("17:00", HORARIO_PATTERN),
					abigail);

			horariosEntregaRepository
					.saveAll(Stream.of(abigailH1, abigailH2, abigailH3, abigailH4, abigailH5, abigailH6, abigailH7)
							.collect(Collectors.toList()));
			log.info("Carregando " + abigail);
		};
	}
}
