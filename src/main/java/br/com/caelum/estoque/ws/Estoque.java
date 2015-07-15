package br.com.caelum.estoque.ws;

import java.util.List;

public interface Estoque {

	ItemEstoque buscaPorCodigo(String codigo);
	
	List<ItemEstoque> buscaPorListaDeCodigo(List<String> codigos);
	
}
