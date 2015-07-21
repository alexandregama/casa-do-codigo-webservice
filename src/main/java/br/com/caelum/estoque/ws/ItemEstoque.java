package br.com.caelum.estoque.ws;

public class ItemEstoque {

	private String codigo;
	
	private int quantidade;

	ItemEstoque() {
	}
	
	public ItemEstoque(String codigo, int quantidade) {
		this.codigo = codigo;
		this.quantidade = quantidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void removeUnidade() {
		this.quantidade--;
	}
	
}
