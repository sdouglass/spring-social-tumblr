package org.springframework.social.tumblr.api.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;

public class TumblrSpring30OAuth1RequestFactory implements
		ClientHttpRequestFactory {

	private final ClientHttpRequestFactory delegate;

	private final TumblrTemplate tumblrTemplate;

	public TumblrSpring30OAuth1RequestFactory(
			ClientHttpRequestFactory delegate, TumblrTemplate tumblrTemplate) {
		this.delegate = delegate;
		this.tumblrTemplate = tumblrTemplate;
	}

	public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod)
			throws IOException {
		return new TumblrOAuth1SigningRequest(delegate.createRequest(uri,
				httpMethod), tumblrTemplate);
	}

	private static class TumblrOAuth1SigningRequest implements
			ClientHttpRequest {

		private final ClientHttpRequest delegate;

		private ByteArrayOutputStream bodyOutputStream;

		private final TumblrSigningSupport signingUtils;

		private final TumblrTemplate tumblrTemplate;

		public TumblrOAuth1SigningRequest(ClientHttpRequest delegate,
				TumblrTemplate tumblrTemplate) {
			this.delegate = delegate;
			this.tumblrTemplate = tumblrTemplate;
			this.bodyOutputStream = new ByteArrayOutputStream();
			this.signingUtils = new TumblrSigningSupport();
		}

		public ClientHttpResponse execute() throws IOException {
			byte[] bufferedOutput = bodyOutputStream.toByteArray();

			String authorizationHeader = signingUtils
					.spring30buildAuthorizationHeaderValue(this,
							bufferedOutput, tumblrTemplate.getCredentials());
			delegate.getBody().write(bufferedOutput);
			delegate.getHeaders().set("Authorization", authorizationHeader);

			ClientHttpResponse reponse = delegate.execute();

			return reponse;
		}

		public URI getURI() {
			return delegate.getURI();
		}

		public HttpMethod getMethod() {
			return delegate.getMethod();
		}

		public HttpHeaders getHeaders() {
			return delegate.getHeaders();
		}

		public OutputStream getBody() throws IOException {
			return bodyOutputStream;
		}
	}
}
