package br.com.caelum.estoque.ws;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
@Stateless
public class EstoqueWS {

	@Inject
	private Estoque estoque;

	public EstoqueWS() {
	}
	
	@WebMethod
	public ItemEstoque getItemEstoque(String codigo) {
		return estoque.buscaPorCodigo(codigo);
	}
	
}
