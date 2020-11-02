package br.unicamp.educorp.microservices.gateway.aula10.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.context.RequestContext;

@Component
public class FilterUtil {

	public static final int FILTER_ORDER = 1;
	public static final boolean SHOULD_FILTER = true;

	private String generateTransactionId() {
		return java.util.UUID.randomUUID().toString();
	}

	public void setTransactionId() {
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.addZuulRequestHeader("trx-id", generateTransactionId());
	}

	public String getTransactionId() {
		RequestContext ctx = RequestContext.getCurrentContext();
		return ctx.getZuulRequestHeaders().get("trx-id");
	}
}
