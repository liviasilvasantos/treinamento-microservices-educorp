package br.unicamp.educorp.microservices.cursos.api.aula4.jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CursosApiAula4JwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursosApiAula4JwtApplication.class, args);
	}

	/**
	 * Password Encoder
	 * 
	 * @return
	 */
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
