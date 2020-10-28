package br.unicamp.educorp.microservices.cardapios.api.aula8.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;

//@RibbonClient(name = "restaurantes-service")
public class RibbonConfiguration {

//	@Bean
	public IRule loadBlancingRule() {
		// ignora servers que estão com alta taxa de conexões concorrentes, ou aqueles
		// servers cuja conexão falharam nas 3 últimas vezes (irá ficar no estado de
		// 'circuit tripped' por 30 segundos)
		new AvailabilityFilteringRule();

		// é dado um peso de acordo com a média do tempo de resposta de cada servidor.
		// quanto maior o tempo de resposta, menor o peso que ele terá
		new WeightedResponseTimeRule();

		// regra mais conhecida - intercala cada requisição entre os servers
		// configurados
		return new RoundRobinRule();
	}
}
