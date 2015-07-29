package br.com.caelum.payfast;

import java.net.URI;
import java.net.URISyntaxException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pagamentos")
public class PagamentoResource {

	@Inject
	private Pagamentos pagamentos;
	
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Pagamento buscaPagamento(@PathParam("id") Integer id) {
		return pagamentos.buscaPor(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response criaPagamento(Transacao transacao) throws URISyntaxException {
		Pagamento pagamento = new Pagamento(transacao.getValor());
		pagamento.comStatusCriado();
		pagamentos.adiciona(pagamento);
		
		return Response.created(new URI("/pagamentos/" + pagamento.getId()))
				.entity(pagamento)
				.type(MediaType.APPLICATION_JSON_TYPE)
				.build();
	}
	
	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pagamento confirmaPagamento(@PathParam("id") Integer id) throws URISyntaxException {
		Pagamento pagamento = pagamentos.buscaPor(id);
		pagamento.comStatusConfirmado();
		
		return pagamento;
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Pagamento cancelarPagamento(@PathParam("id") Integer id) {
		Pagamento pagamento = pagamentos.buscaPor(id);
		pagamento.comStatusCancelado();
		
		return pagamento;
	}
	
}
