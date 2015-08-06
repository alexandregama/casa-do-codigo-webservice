package br.com.caelum.payfast;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.common.base.MoreObjects;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Link {

	private String rel;
	private String uri;
	private HttpMethod method;
	
	@Deprecated //JAX-B eyes only
	Link() {
	}

	public Link(String rel, String uri, HttpMethod method) {
		this.rel = rel;
		this.uri = uri;
		this.method = method;
	}

	public String getRel() {
		return rel;
	}

	public String getUri() {
		return uri;
	}

	public String getMethod() {
		return method.toString();
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.addValue("Link[")
				.add("rel", rel)
				.add("uri", uri)
				.add("method", method)
				.addValue("]").toString();
	}
	
}
