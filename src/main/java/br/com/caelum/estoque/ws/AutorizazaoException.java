package br.com.caelum.estoque.ws;

import javax.xml.ws.WebFault;

@WebFault(name = "AutorizacaoFault")
public class AutorizazaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AutorizazaoException(String message) {
		super(message);
	}
	
}
