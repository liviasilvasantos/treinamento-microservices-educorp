package br.unicamp.educorp.microservices.cursos.api.aula4.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
//oauth config
//@EnableAuthorizationServer
//@EnableResourceServer
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Configura os critérios de acesso aos endpoints (o que é liberado e o que é
	 * necessário estar autenticado). Configura também a forma de autenticação
	 * (httpbasic, por exemplo)
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// utiliza configuração cors definida no bean abaixo
		http.cors().and()//
				.csrf().disable(); // desativa ataques Cross-Site Request Forgery (CSRF)

		http//
				.authorizeRequests()//
				.antMatchers("/public/**").permitAll()// para requisicoes em public, permitir tudo
				.antMatchers("/admin/**").hasRole("ADMIN")// para requisicoes em admin, precisa ter autorizacao de admin
				.anyRequest().authenticated()// para qualquer outra requisicao, precisa estar autenticado
				.and()//
				.httpBasic().realmName("RealmEducorp")//
				.and()//
				// desativa criação de sessão no backend
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	/**
	 * Configura a forma de autenticação em memória, criando os usuários user e
	 * admin, com senhas criptogradas e perfis (ROLES).
	 * 
	 * @param authentication
	 * @throws Exception
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {
		authentication//
				.inMemoryAuthentication()//
				.withUser("user").password(passwordEncoder().encode("teste")).authorities("ROLE_USER")//
				.and()//
				.withUser("admin").password(passwordEncoder().encode("admin")).authorities("ROLE_ADMIN");
	}

	/**
	 * Password Encoder
	 * 
	 * @return
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Cors Configuration
	 * 
	 * @return
	 */
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

		// permit all cross-origin requests for GET, HEAD, and POST requests
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());

		return source;
	}
}
