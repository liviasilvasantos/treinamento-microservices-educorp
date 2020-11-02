package br.unicamp.educorp.microservices.gateway.aula10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GatewayAula10Application {

	public static void main(String[] args) {
		SpringApplication.run(GatewayAula10Application.class, args);
	}

}
