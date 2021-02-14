package br.unicamp.educorp.microservices.cursos.api.aula4.jwt.security;

public interface SecurityConstants {

	public static final String SECRET = "SecretKeyEducorp";
	public static final long EXPIRATION_TIME = 60 * 60 * 5; // 5 segundos
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/usuarios/registre-se";
}
