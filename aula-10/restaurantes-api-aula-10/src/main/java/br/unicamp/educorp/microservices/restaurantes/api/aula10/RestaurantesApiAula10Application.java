package br.unicamp.educorp.microservices.restaurantes.api.aula10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RestaurantesApiAula10Application {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantesApiAula10Application.class, args);
	}

}
