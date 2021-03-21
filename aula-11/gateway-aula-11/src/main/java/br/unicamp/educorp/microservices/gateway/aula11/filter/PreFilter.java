package br.unicamp.educorp.microservices.gateway.aula11.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreFilter extends ZuulFilter {

	private static final Logger log = LoggerFactory.getLogger(PreFilter.class);

	@Autowired
	private FilterUtil filterUtil;

	@Override
	public boolean shouldFilter() {
		return FilterUtil.SHOULD_FILTER;
	}

	@Override
	public Object run() throws ZuulException {
		filterUtil.setTransactionId();
		log.info("transaction id created {}", filterUtil.getTransactionId());
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterUtil.FILTER_ORDER;
	}

}
