package br.com.caelum.payfast;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pagamentos")
@Singleton
public class PagamentoResource {

	private Map<Integer, Pagamento> repositorio = new HashMap<Integer, Pagamento>();
	private Integer id = 1;
	
	public PagamentoResource() {
		Pagamento pagamento = new Pagamento(id++, BigDecimal.TEN);
		pagamento.comStatusCriado();
		repositorio.put(pagamento.getId(), pagamento);
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Pagamento buscaPagamento(@PathParam("id") Integer id) {
		return repositorio.get(id);
	}
	
}
