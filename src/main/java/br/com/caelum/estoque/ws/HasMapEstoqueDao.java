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
		repositorio.put("SOA", new ItemEstoque("SOA", 15));
		repositorio.put("TDD", new ItemEstoque("TDD", 10));
		repositorio.put("RES", new ItemEstoque("RES", 20));
		repositorio.put("LOG", new ItemEstoque("LOG", 8));
		repositorio.put("WEB", new ItemEstoque("WEB", 12));
		repositorio.put("ARQ", new ItemEstoque("ARQ", 19));
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
