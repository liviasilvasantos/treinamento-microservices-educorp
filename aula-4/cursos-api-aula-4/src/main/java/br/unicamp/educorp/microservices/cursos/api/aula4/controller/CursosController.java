package br.unicamp.educorp.microservices.cursos.api.aula4.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import br.unicamp.educorp.microservices.cursos.api.aula4.hateoas.LinkWithMethod;
import br.unicamp.educorp.microservices.cursos.api.aula4.model.Curso;
import br.unicamp.educorp.microservices.cursos.api.aula4.model.CursoDto;
import br.unicamp.educorp.microservices.cursos.api.aula4.model.filter.FiltroCurso;
import br.unicamp.educorp.microservices.cursos.api.aula4.repository.CursosRepository;

@RestController
public class CursosController {

	private static final Logger log = LoggerFactory.getLogger(CursosController.class);

	@Autowired
	private CursosRepository cursoRepository;

	@Autowired
	private Environment environment;

	@Autowired
	private ModelMapper modelMapper;

	private String getHostPorta() {
		return environment.getProperty("local.server.port");
	}

	@GetMapping("/v3/cursos")
	public ResponseEntity<?> getAllCursos() {
		log.info("buscando todos os cursos na porta {}", getHostPorta());
		return new ResponseEntity<List<Curso>>(cursoRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/v3/cursos/{id}")
	public ResponseEntity<?> getCurso(@PathVariable Integer id) {
		log.info("buscando o curso {} na porta {}", id, getHostPorta());
		return new ResponseEntity<Curso>(cursoRepository.findById(id).get(), HttpStatus.OK);
	}

	@PostMapping(value = "/v3/cursos")
	public ResponseEntity<?> saveCurso(@RequestBody Curso curso, UriComponentsBuilder uriBuilder) {
		log.info("salvando novo curso {} na porta {}", curso, getHostPorta());
		try {
			Curso salvo = cursoRepository.save(curso);

			// retorna um path para o curso salvo no header da resposta
			URI path = uriBuilder.path("/v3/cursos/{id}").buildAndExpand(salvo.getId()).toUri();
			return ResponseEntity.created(path).body(salvo);

//			return new ResponseEntity<Curso>(cursoRepository.save(curso), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Curso>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/v3/cursos/{id}")
	public ResponseEntity<?> deleteCurso(@PathVariable Integer id) {
		log.info("excluindo curso {} na porta {}", id, getHostPorta());
		try {
			cursoRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} catch (Exception e) {
			return new ResponseEntity<Curso>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping(value = "/v3/cursos/{id}")
	public ResponseEntity<?> saveCurso(@PathVariable Integer id, @RequestBody Curso curso) {
		log.info("atualizando curso id {} na porta {}", id, getHostPorta());

		Optional<Curso> cursoEntity = cursoRepository.findById(id);

		if (cursoEntity.isPresent()) {
			Curso _curso = cursoEntity.get();
			_curso.setCodigo(curso.getCodigo());
			_curso.setDescricao(curso.getDescricao());
			return new ResponseEntity<Curso>(cursoRepository.save(curso), HttpStatus.OK);
		} else {
			return new ResponseEntity<Curso>(HttpStatus.NOT_FOUND);
		}
	}

	@Deprecated
	@PostMapping(value = "/v3/cursos/filter")
	public ResponseEntity<?> getCursoByFilter(@RequestBody FiltroCurso filtro) {
		log.info("buscando o curso com filtro {} na porta {}", filtro, getHostPorta());

		List<Curso> cursos = cursoRepository.findAllByCodigoContains(filtro.getCodigo());

		if (cursos == null || cursos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
	}

	@GetMapping(value = "/v3/cursos/filter2")
	public ResponseEntity<?> getCursoByFilter2(@ModelAttribute FiltroCurso filtro) {
		log.info("buscando o curso com filtro {} na porta {}", filtro, getHostPorta());

//		List<Curso> cursos = cursoRepository.findAllByCodigoContainsAndDescricaoContains(filtro.getCodigo(),
//				filtro.getDescricao());

		Pageable page = PageRequest.of(filtro.getPage(), filtro.getPageSize());
		List<Curso> cursos = cursoRepository.findAllByCodigoContains(filtro.getCodigo(), page);

		if (cursos == null || cursos.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		return new ResponseEntity<List<Curso>>(cursos, HttpStatus.OK);
	}

	// Hateoas

	@GetMapping("/v4/cursos/hateoas/{id}")
	public ResponseEntity<?> getCursoHateoas(@PathVariable Integer id) {
		log.info("buscando o curso hateoas {} na porta {}", id, getHostPorta());

		Optional<Curso> curso = cursoRepository.findById(id);

		List<Link> links = new ArrayList<Link>();

		if (curso.isPresent()) {
			Link linkSelf = linkTo(methodOn(CursosController.class).getCurso(id)).withSelfRel();
			Link linkAll = linkTo(methodOn(CursosController.class).getAllCursos()).withRel("all");

			// adição do método http
			links.add(new LinkWithMethod(linkSelf, HttpMethod.GET.toString()));
			links.add(new LinkWithMethod(linkAll, HttpMethod.GET.toString()));

			EntityModel<Curso> model = EntityModel.of(curso.get(), //
					links);

//			EntityModel<Curso> model = EntityModel.of(curso.get(), //
//					linkTo(methodOn(CursosController.class).getCurso(id)).withSelfRel(),
//					linkTo(methodOn(CursosController.class).getAllCursos()).withRel("all"));

			return ResponseEntity.ok(model);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/v4/cursos/hateoas")
	public ResponseEntity<?> getAllCursoHateoas() {
		log.info("buscando todos os curso hateoas na porta {}", getHostPorta());

		List<EntityModel<Curso>> cursosModel = new ArrayList<EntityModel<Curso>>();
		List<Curso> cursos = cursoRepository.findAll();

		for (Curso c : cursos) {
			cursosModel.add(EntityModel.of(c, //
					linkTo(methodOn(CursosController.class).getCurso(c.getId())).withSelfRel(),
					linkTo(methodOn(CursosController.class).getAllCursos()).withRel("all")));
		}

		return new ResponseEntity<List<EntityModel<Curso>>>(cursosModel, HttpStatus.OK);
	}

	// Jackson

	@GetMapping("/v4/cursos/mapping")
	public MappingJacksonValue getAllCursosMapping() {
		log.info("buscando todos os cursos mapping na porta {}", getHostPorta());

		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("codigo", "descricao");
		FilterProvider filters = new SimpleFilterProvider().addFilter("CursoFilter", filter);

		MappingJacksonValue mapping = new MappingJacksonValue(cursoRepository.findAll());
		mapping.setFilters(filters);

		return mapping;
	}

	@GetMapping("/v4/cursos/dto")
	public ResponseEntity<?> getAllCursosDto() {
		log.info("buscando todos os cursos dto na porta {}", getHostPorta());

		List<Curso> cursos = cursoRepository.findAll();
		List<CursoDto> cursosDto = cursos//
				.stream()//
				.map(this::convertToDto)//
				.collect(Collectors.toList());
		return new ResponseEntity<List<CursoDto>>(cursosDto, HttpStatus.OK);
	}

	private CursoDto convertToDto(Curso curso) {
		CursoDto cursoDto = modelMapper.map(curso, CursoDto.class);
		return cursoDto;
	}
}
