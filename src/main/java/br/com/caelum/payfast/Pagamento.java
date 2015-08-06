package br.com.caelum.payfast;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.MoreObjects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pagamento {

	private static final String URI = "/pagamentos/";

	private static final String REL_CANCELAR = "cancelar";
	private static final String REL_CONFIRMAR = "confirmar";
	private static final String REL_SELF = "self";
	
	private static final String STATUS_CRIADO = "CRIADO";
	private static final String STATUS_CONFIRMADO = "CONFIRMADO";
	private static final String STATUS_CANCELADO = "CANCELADO";
	
	@XmlAttribute
	private Integer id;
	@XmlElement(name = "estadoAtual")
	private String status;
	private BigDecimal valor;
	private ArrayList<Link> links = new ArrayList<>();
	
	@Deprecated //JAX-B eyes only
	Pagamento() {
	}

	public Pagamento(BigDecimal valor) {
		this.valor = valor;
		this.comStatusCriado();
	}

	public void comStatusCriado() {
		this.status = STATUS_CRIADO;
		this.links.clear();
		this.addLink(new Link(REL_CONFIRMAR, URI + this.getId(), HttpMethod.PUT));
		this.addLink(new Link(REL_CANCELAR, URI + this.getId(), HttpMethod.DELETE));
	}

	public void comStatusConfirmado() {
		if (this.id == null) {
			throw new IllegalArgumentException("id do pagamento deve existir");
		}
		
		if(this.status == null || !this.status.equals(STATUS_CRIADO)) {
			throw new IllegalStateException("status deve ser " + STATUS_CRIADO);
		}

		this.status = STATUS_CONFIRMADO;
		this.links.clear();
		this.addLink(new Link(REL_SELF, URI + this.getId(), HttpMethod.GET));
	}

	public void comStatusCancelado() {
		if (this.id == null) {
			throw new IllegalArgumentException("id do pagamento deve existir");
		}
		
		if(this.status == null || !this.status.equals(STATUS_CRIADO)) {
			throw new IllegalStateException("status deve ser " + STATUS_CRIADO);
		}

		this.status = STATUS_CANCELADO;
		this.links.clear();
		this.addLink(new Link(REL_SELF, URI + this.getId(), HttpMethod.GET));
	}
	
	public Link getLinkPeloRel(String rel) {
		for (Link link : this.links) {
			if(link.getRel().equals(rel)) {
				return link;
			}
		}
		return null;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Integer getId() {
		return id;
	}

	public List<Link> getLinks() {
		return Collections.unmodifiableList(links);
	}

	public void addLink(Link link) {
		this.links.add(link);
	}
	
	public boolean ehCriado() {
		return STATUS_CRIADO.equals(this.status);
	}
	
	public boolean ehConfirmado() {
		return STATUS_CONFIRMADO.equals(this.status);
	}
	
	public boolean ehCancelado() {
		return STATUS_CANCELADO.equals(this.status);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("id", id)
				.add("status", status)
				.add("valor", valor)
				.add("links", links)
				.toString();
	}
	
}
