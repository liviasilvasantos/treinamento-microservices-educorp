package br.unicamp.educorp.microservices.cardapios.api.aula11.client;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.Request;

public class FeignConfiguration {

	/*
	 * Define o nível de log para o client feign.
	 */
	@Bean
	public Logger.Level configureLogLevel() {
		return Logger.Level.FULL;
	}

	/*
	 * Configura o valor timeout de conexão e de leitura, que serão usado pelo
	 * client em cada requisição.
	 */
	@Bean
	public Request.Options timeoutConfiguration() {
		return new Request.Options(5000, TimeUnit.MILLISECONDS, 30000, TimeUnit.MILLISECONDS, false);
	}

}
