package br.com.caelum.estoque.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

@Stateless
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

	@Override
	public List<ItemEstoque> buscaPorListaDeCodigo(List<String> codigos) {
		List<ItemEstoque> itens = new ArrayList<>();
		
		for (String codigo : codigos) {
			if (repositorio.containsKey(codigo)) {
				itens.add(repositorio.get(codigo));
			}
		}
		return itens;
	}

}
