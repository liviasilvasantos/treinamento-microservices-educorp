package br.unicamp.educorp.microservices.cursos.api.aula4;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.unicamp.educorp.microservices.cursos.api.aula4.model.Curso;
import br.unicamp.educorp.microservices.cursos.api.aula4.model.CursoDto;


@SpringBootApplication
public class CursosApiAula4Application {

	public static void main(String[] args) {
		SpringApplication.run(CursosApiAula4Application.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.typeMap(Curso.class, CursoDto.class)//
				.addMappings(mapper -> {
					mapper.map(src -> src.getId(), CursoDto::setIdentification);
					mapper.map(src -> src.getCodigo(), CursoDto::setCode);
					mapper.map(src -> src.getDescricao(), CursoDto::setDescription);
				});

		return modelMapper;
	}
}
