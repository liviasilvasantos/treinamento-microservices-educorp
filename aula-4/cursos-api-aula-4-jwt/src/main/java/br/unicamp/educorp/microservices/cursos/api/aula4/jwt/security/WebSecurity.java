package br.unicamp.educorp.microservices.cursos.api.aula4.jwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.unicamp.educorp.microservices.cursos.api.aula4.jwt.security.filter.JWTAuthenticationFilter;
import br.unicamp.educorp.microservices.cursos.api.aula4.jwt.security.filter.JWTAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()//
				.and().csrf().disable()//
				.authorizeRequests()//
				// permite POST para a url de sign up
				.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()//
				// qualquer outra requisição, precisa estar logado
				.anyRequest().authenticated()//
				// adiciona o filtro de autenticação JWT - login
				.and().addFilter(new JWTAuthenticationFilter(authenticationManager()))
				// adiciona o filtro de autorização JWT - outros recursos
				.addFilter(new JWTAuthorizationFilter(authenticationManager()))
				// desativa criação de sessão no backend
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	/**
	 * Informa qual a implementação do serviço utilizado para recuperar o usuário e
	 * qual o codificador da senha.
	 */
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth //
				.userDetailsService(userDetailsService)//
				.passwordEncoder(bCryptPasswordEncoder);
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
