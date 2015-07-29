package br.com.caelum.payfast;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PagamentoResourceTest {

	@Mock
	private Pagamentos pagamentos;
	
	@InjectMocks
	private PagamentoResource resource;
	
	@Test
	public void deveriaBuscarUmPagamentoPeloId() throws Exception {
		resource.buscaPagamento(1);
		
		verify(pagamentos).buscaPor(1);
	}
	
	@Test
	public void deveriaAdicionarUmPagamentoQuandoUmPagamentoForCriado() throws Exception {
		Transacao transacao = new Transacao();
		
		resource.criaPagamento(transacao);
		
		verify(pagamentos).adiciona(any(Pagamento.class));
	}
	
	@Test
	public void deveriaConfirmarUmPagamento() throws Exception {
		Pagamento pagamento = mock(Pagamento.class);
		when(pagamentos.buscaPor(1)).thenReturn(pagamento);
		
		resource.confirmaPagamento(1);
		
		verify(pagamento).comStatusConfirmado();
	}
	
	@Test
	public void deveriaCancelarUmPagamento() throws Exception {
		Pagamento pagamento = mock(Pagamento.class);
		when(pagamentos.buscaPor(1)).thenReturn(pagamento);
		
		resource.cancelarPagamento(1);
		
		verify(pagamento).comStatusCancelado();
	}
	
}
