package br.unicamp.educorp.microservices.restaurantes.api.aula8;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RestaurantesApiAula8Application {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantesApiAula8Application.class, args);
	}

}
