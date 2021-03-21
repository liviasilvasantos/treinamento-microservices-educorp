package br.unicamp.educorp.microservices.discovery.server.aula11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerAula11Application {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerAula11Application.class, args);
	}

}
