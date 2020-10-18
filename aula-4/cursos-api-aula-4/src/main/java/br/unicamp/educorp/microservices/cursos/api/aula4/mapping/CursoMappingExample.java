package br.unicamp.educorp.microservices.cursos.api.aula4.mapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;

public class CursoMappingExample {
	private static final Logger log = LoggerFactory.getLogger(CursoMappingExample.class);

	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);

		// POJO to JSON
		CursoPOJO curso = new CursoPOJO(1000, "JS", "Javascript");
		log.info("POJO to JSON \n{}", objectMapper//
				.writerWithDefaultPrettyPrinter()//
				.writeValueAsString(curso));

		// List of POJO to JSON
		CursoPOJO curso2 = new CursoPOJO(1001, "XML", "XML");
		List<CursoPOJO> cursos = Stream.of(curso, curso2).collect(Collectors.toList());
		log.info("List of POJO to JSON \n{}", objectMapper//
				.writerWithDefaultPrettyPrinter()//
				.writeValueAsString(cursos));

		// JSON to POJO
		String json = "{ \"id\" : \"1002\", \"codigo\" : \"BIZ\", \"descricao\":\"Bizagi\" }";
		CursoPOJO cursoPOJO = objectMapper.readValue(json, CursoPOJO.class);
		log.info("JSON to POJO \n{}", cursoPOJO);

		// JSON Node
		JsonNode jsonNode = objectMapper.readTree(json);
		String descricao = jsonNode.get("descricao").asText();
		log.info("Node Descrição: {}", descricao);

		// JSON to List of POJO
		String jsonCursoArray = "[ {\n" + "  \"id\" : 1000,\n" + "  \"codigo\" : \"JS\",\n"
				+ "  \"descricao\" : \"Javascript\"\n" + "}, {\n" + "  \"id\" : 1001,\n" + "  \"codigo\" : \"XML\",\n"
				+ "  \"descricao\" : \"XML\"\n" + "} ]";
		List<CursoPOJO> cursosPOJO = objectMapper//
				.readValue(jsonCursoArray, new TypeReference<List<CursoPOJO>>() {
				});
		log.info("JSON to List of POJO \n{}", cursosPOJO);

		// Deserialization Feature
		try {
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
			String json2 = "{ \"id\" : \"1003\", \"autor\" : \"Lívia Silva Santos\", \"descricao\":\"Camunda\" }";
			CursoPOJO cursoPOJO2 = objectMapper.readValue(json2, CursoPOJO.class);
			log.info("JSON to POJO \n{}", cursoPOJO2);
		} catch (UnrecognizedPropertyException ex) {
			log.error("erro ao transformar json to pojo - propriedade não conhecida", ex);
		}

		// Deserialization Feature - default value
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String json2 = "{ \"id\" : \"1003\", \"autor\" : \"Lívia Silva Santos\", \"descricao\":\"Camunda\" }";
		CursoPOJO cursoPOJO2 = objectMapper.readValue(json2, CursoPOJO.class);
		log.info("JSON to POJO \n{}", cursoPOJO2);
		JsonNode jsonNodeRoot = objectMapper.readTree(json2);
		JsonNode jsonNodeAutor = jsonNodeRoot.get("autor");
		String autor = jsonNodeAutor.asText();
		log.info("Node Autor: {}", autor);

		// Date
		CursoPOJO cursoComDate = new CursoPOJO(1004, "WIN", "Windows");
		cursoComDate.setDataInicio(new Date());
		log.info("POJO com Date to JSON\n{}", objectMapper//
				.writerWithDefaultPrettyPrinter()//
				.writeValueAsString(cursoComDate));

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
		objectMapper.setDateFormat(df);
		log.info("POJO com Date to JSON com Date Formatado\n{}", objectMapper//
				.writerWithDefaultPrettyPrinter()//
				.writeValueAsString(cursoComDate));

		// Mixin
		objectMapper = new ObjectMapper();
		objectMapper.addMixIn(CursoPOJO.class, CursoPOJOMixin.class);

		log.info("POJO to JSON With Mixin\n{}", objectMapper//
				.writerWithDefaultPrettyPrinter()//
				.writeValueAsString(cursoComDate));
	}
}
