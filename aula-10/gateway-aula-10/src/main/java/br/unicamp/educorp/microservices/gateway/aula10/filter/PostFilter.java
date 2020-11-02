package br.unicamp.educorp.microservices.gateway.aula10.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostFilter extends ZuulFilter {

	private static final Logger log = LoggerFactory.getLogger(PostFilter.class);

	@Override
	public boolean shouldFilter() {
		return FilterUtil.SHOULD_FILTER;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		log.info("response http status code {}", ctx.getResponse().getStatus());
		return null;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;

	}

	@Override
	public int filterOrder() {
		return FilterUtil.FILTER_ORDER;
	}

}
