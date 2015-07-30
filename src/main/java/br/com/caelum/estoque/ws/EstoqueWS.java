package br.com.caelum.estoque.ws;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@Stateless
@WebService(targetNamespace = "http://caelum.com.br/estoquews/v1")
public class EstoqueWS {

	@Inject
	private Estoque estoque;

	public EstoqueWS() {
	}
	
	@WebMethod(operationName = "buscaItemEstoque")
	@WebResult(name = "ItemEstoque")
	public ItemEstoque getItemEstoque(@WebParam(name = "codigo") String codigo, @WebParam(name = "tokenUsuario", header = true) String token) {
		if (token == null || !token.equals("TOKEN123")) {
			throw new AutorizazaoException("Nao autorizado");
		} 
	
		return estoque.buscaPorCodigo(codigo);
	}
	
	@WebMethod(operationName = "buscaItensEstoque")
	@WebResult(name = "ItensEstoque")
	public List<ItemEstoque> getItensEstoque(@WebParam(name = "codigos") List<String> codigos, @WebParam(name = "tokenUsuario", header = true) String token) {
		return estoque.buscaPorListaDeCodigo(codigos);
	}
	
	//Este metodo existe somente para validarmos como o metodo é exibido no WSDL sem usar os recursos do JAX-WS
	@WebMethod
	public List<ItemEstoque> getQuantidade(List<String> codigos) {
		return estoque.buscaPorListaDeCodigo(codigos);
	}
	
}
