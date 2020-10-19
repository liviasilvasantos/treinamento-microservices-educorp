package br.unicamp.educorp.microservices.cursos.api.aula4.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()//
				.antMatchers("/public/**").permitAll()// para requisicoes em public, permitir tudo
				.antMatchers("/admin/**").hasRole("ADMIN")// para requisicoes em admin, precisa ter autorizacao de admin
				.anyRequest().authenticated()// para qualquer outra requisicao, precisa estar autenticado
				.and()//
				.httpBasic();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
		authentication//
				.inMemoryAuthentication()//
				.withUser("user").password(passwordEncoder().encode("teste")).authorities("ROLE_USER")//
				.and()//
				.withUser("admin").password(passwordEncoder().encode("admin")).authorities("ROLE_ADMIN");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
