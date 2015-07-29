package br.com.caelum.payfast;

public interface Pagamentos {

	Pagamento adiciona(Pagamento pagamento);

	Pagamento buscaPor(Integer id);
	
}
