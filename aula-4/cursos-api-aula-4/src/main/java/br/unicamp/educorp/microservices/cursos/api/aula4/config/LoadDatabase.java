package br.unicamp.educorp.microservices.cursos.api.aula4.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.unicamp.educorp.microservices.cursos.api.aula4.model.Curso;
import br.unicamp.educorp.microservices.cursos.api.aula4.repository.CursosRepository;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	public CommandLineRunner initDatabase(CursosRepository repository) {
		return args -> {
			log.info("Carregando " + repository.save(new Curso(1000, "IOT", "Internet of Things")));
			log.info("Carregando " + repository.save(new Curso(1001, "DAS", "Data Science")));
			log.info("Carregando " + repository.save(new Curso(1002, "MON", "Mongo DB")));
		};
	}
}
