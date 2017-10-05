package br.com.fiap.rs.exemplos;

import javax.xml.bind.annotation.XmlRootElement;

public class Retorno {
	private String mensagem;

	public Retorno(String mensagem) {
		this.mensagem = mensagem;
	}

	public Retorno() {
	}


	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}
