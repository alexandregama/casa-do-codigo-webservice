package br.com.caelum.payfast;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Pagamento buscaPagamento(@PathParam("id") Integer id) {
		return repositorio.get(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response criaPagamento(Transacao transacao) throws URISyntaxException {
		Pagamento pagamento = new Pagamento(id++, transacao.getValor());
		pagamento.comStatusCriado();
		repositorio.put(pagamento.getId(), pagamento);
		
		return Response.created(new URI("/pagamentos/" + pagamento.getId()))
				.entity(pagamento)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pagamento confirmaPagamento(@PathParam("id") Integer id) throws URISyntaxException {
		Pagamento pagamento = repositorio.get(id);
		pagamento.comStatusConfirmado();
		
		return pagamento;
	}
	
}
