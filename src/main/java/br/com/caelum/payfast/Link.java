package br.com.caelum.payfast;

import com.google.common.base.MoreObjects;

public class Link {

	private String rel;
	private String uri;
	private HttpMethod method;

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
