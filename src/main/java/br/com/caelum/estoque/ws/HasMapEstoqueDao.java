package br.com.caelum.estoque.ws;

import java.util.HashMap;
import java.util.Map;

public class HasMapEstoqueDao implements Estoque {

	private Map<String, ItemEstoque> repositorio = new HashMap<>();
	
	public HasMapEstoqueDao() {
		repositorio.put("SOA", new ItemEstoque("SOA", 5));
		repositorio.put("TDD", new ItemEstoque("TDD", 1));
		repositorio.put("RES", new ItemEstoque("RES", 2));
		repositorio.put("LOG", new ItemEstoque("LOG", 4));
		repositorio.put("WEB", new ItemEstoque("WEB", 1));
		repositorio.put("ARQ", new ItemEstoque("ARQ", 2));
	}
	
	@Override
	public ItemEstoque buscaPorCodigo(String codigo) {
		return repositorio.get(codigo);
	}

}
