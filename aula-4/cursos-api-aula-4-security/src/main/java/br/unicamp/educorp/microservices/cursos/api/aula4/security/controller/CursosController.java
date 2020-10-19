package br.unicamp.educorp.microservices.cursos.api.aula4.security.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursosController {

	@GetMapping("/v5/cursos")
	public ResponseEntity<String> getCursos() {
		return ResponseEntity.ok("cursos restricted controller up " + new Date());
	}

	@GetMapping("/public/v5/cursos")
	public ResponseEntity<String> getCursosPublic() {
		return ResponseEntity.ok("cursos public controller up " + new Date());
	}

	@GetMapping("/admin/v5/cursos")
	public ResponseEntity<String> getCursosAdmin() {
		return ResponseEntity.ok("cursos admin controller up " + new Date());
	}
}
