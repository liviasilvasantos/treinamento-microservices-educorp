package br.unicamp.educorp.microservices.cursos.api.aula4.jwt.security.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.unicamp.educorp.microservices.cursos.api.aula4.jwt.model.ApplicationUser;
import br.unicamp.educorp.microservices.cursos.api.aula4.jwt.security.SecurityConstants;

/**
 * Filtro que o Spring Security irá interceptar o endpoint /login.
 *
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	/**
	 * Realiza a autenticação de usuário e senha enviados na requisição
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException {
		try {
			// recebe os valores de login da requisição (username/password)
			ApplicationUser creds = new ObjectMapper().readValue(req.getInputStream(), ApplicationUser.class);

			// realiza a autenticação conforme implementação definida no WebSecurity Config.
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(),
					creds.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Se a autenticação ocorrer com sucesso, retorna um token no header da resposta
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		// gera o token JWT - que expira em 10 dias
		String token = JWT.create()//
				.withSubject(((User) auth.getPrincipal()).getUsername()) //
				.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME)) //
				// algoritmo se assinatura do token e qual o segredo
				.sign(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()));

		// adiciona no header da resposta, a chave Authorization: Bearer + token gerado
		res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
	}
}
