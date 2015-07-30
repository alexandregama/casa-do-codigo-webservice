package br.com.caelum.payfast;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;

@Singleton
public class HasMapPagamentoDao implements Pagamentos {

	private Map<Integer, Pagamento> repositorio = new HashMap<>();
	private Integer id = 1;
	
	public HasMapPagamentoDao() {
		Pagamento pagamento = new Pagamento(BigDecimal.TEN);
		pagamento.setId(id);
		pagamento.comStatusCriado();
		repositorio.put(pagamento.getId(), pagamento);
	}
	
	@Override
	public Pagamento adiciona(Pagamento pagamento) {
		pagamento.setId(++id);
		repositorio.put(pagamento.getId(), pagamento);
		return pagamento;
	}

	@Override
	public Pagamento buscaPor(Integer id) {
		return repositorio.get(id);
	}

}
