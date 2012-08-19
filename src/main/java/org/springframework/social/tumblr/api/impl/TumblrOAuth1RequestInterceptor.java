package org.springframework.social.tumblr.api.impl;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.social.support.HttpRequestDecorator;

import java.io.IOException;

/**
 * Copy of Spring Social's OAuth1RequestInterceptor, which is not public. Uses a
 * custom version of Spring Social's also not-public SigningSupport class.
 *
 * @author sam
 * @version $Id$
 */
public class TumblrOAuth1RequestInterceptor implements ClientHttpRequestInterceptor {

    private final TumblrSigningSupport signingUtils;
    private final TumblrTemplate tumblrTemplate;

    public TumblrOAuth1RequestInterceptor(TumblrTemplate tumblrTemplate) {
        this.tumblrTemplate = tumblrTemplate;
        this.signingUtils = new TumblrSigningSupport();
    }

    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpRequest protectedResourceRequest = new HttpRequestDecorator(request);
        if (tumblrTemplate.isAuthorized())
        {
        	protectedResourceRequest.getHeaders().add("Authorization", getAuthorizationHeaderValue(request, body));
        }
        return execution.execute(protectedResourceRequest, body);
    }

	// internal helpers

	private String getAuthorizationHeaderValue(HttpRequest request, byte[] body) {
		return signingUtils.buildAuthorizationHeaderValue(request, body, tumblrTemplate.getCredentials());
	}
}
