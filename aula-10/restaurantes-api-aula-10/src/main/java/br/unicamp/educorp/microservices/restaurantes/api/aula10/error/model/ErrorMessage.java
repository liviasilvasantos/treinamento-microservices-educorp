package br.unicamp.educorp.microservices.restaurantes.api.aula10.error.model;

import java.util.Date;

public class ErrorMessage {

	private Date dataOcorrencia;
	private int statusCode;
	private String statusError;
	private String mensagem;
	private String path;

	public ErrorMessage() {
		super();
	}

	public ErrorMessage(int statusCode, String statusError, String mensagem, String path) {
		super();
		this.dataOcorrencia = new Date();
		this.statusCode = statusCode;
		this.statusError = statusError;
		this.mensagem = mensagem;
		this.path = path;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusError() {
		return statusError;
	}

	public void setStatusError(String statusError) {
		this.statusError = statusError;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
