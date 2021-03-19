package br.unicamp.educorp.microservices.discovery.server.aula10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerAula10Application {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerAula10Application.class, args);
	}

}
