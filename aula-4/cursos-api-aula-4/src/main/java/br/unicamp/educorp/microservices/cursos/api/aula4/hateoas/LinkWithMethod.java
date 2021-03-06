package br.unicamp.educorp.microservices.cursos.api.aula4.hateoas;

import org.springframework.hateoas.Link;

@SuppressWarnings("serial")
public class LinkWithMethod extends Link {

	private String method;

	public LinkWithMethod(Link link, String method) {
		super(link.getHref(), link.getRel());
		this.method = method;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

}
