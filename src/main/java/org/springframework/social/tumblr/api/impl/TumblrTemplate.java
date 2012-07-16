package org.springframework.social.tumblr.api.impl;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.tumblr.api.BlogOperations;
import org.springframework.social.tumblr.api.Tumblr;
import org.springframework.social.tumblr.api.UserOperations;
import org.springframework.util.ClassUtils;
import org.springframework.web.client.RestTemplate;

public class TumblrTemplate extends AbstractOAuth1ApiBinding implements Tumblr {

	private static boolean interceptorsSupported = ClassUtils.isPresent(
			"org.springframework.http.client.ClientHttpRequestInterceptor",
			TumblrTemplate.class.getClassLoader());
	
	private String apiKey;

	private UserOperations userOperations;

	private TumblrOAuth1Credentials credentials;

	public TumblrTemplate(String consumerKey, String consumerSecret,
			String accessToken, String accessTokenSecret) {
		super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		this.apiKey = consumerKey;
		credentials = new TumblrOAuth1Credentials(consumerKey, consumerSecret,
				accessToken, accessTokenSecret);
		initApis();
	}

	public TumblrOAuth1Credentials getCredentials() {
		return credentials;
	}

	@Override
	protected void configureRestTemplate(RestTemplate restTemplate) {
		List<HttpMessageConverter<?>> oldMessageConverters = restTemplate
				.getMessageConverters();
		for (HttpMessageConverter<?> converter : oldMessageConverters) {
			if (converter instanceof FormHttpMessageConverter) {
				// use LATIN1 character set for all form posts...?
				((FormHttpMessageConverter) converter).setCharset(Charset
						.forName("LATIN1"));
			}
		}
		// replace the default OAuth1 interceptor with a custom one that uses a
		// custom SigningSupport impl
		// doing some hokey stuff here to make the credentials available to the
		// interceptor

		if (interceptorsSupported) {
			TumblrOAuth1RequestInterceptor interceptor = new TumblrOAuth1RequestInterceptor(
					this);
			List<ClientHttpRequestInterceptor> newInterceptors = new ArrayList<ClientHttpRequestInterceptor>();
			newInterceptors.add(interceptor);
			restTemplate.setInterceptors(newInterceptors);
		} else {
			restTemplate
					.setRequestFactory(new TumblrSpring30OAuth1RequestFactory(
							restTemplate.getRequestFactory(), this));
		}
	}

	@Override
	protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
		return new TumblrHttpMessageConverter();
	}

	public BlogOperations blogOperations(String blogHostname) {
		return new BlogTemplate(getRestTemplate(), isAuthorized(), apiKey,
				blogHostname);
	}

	public UserOperations userOperations() {
		return userOperations;
	}

	private void initApis() {
		this.userOperations = new UserTemplate(getRestTemplate(),
				isAuthorized(), apiKey);
	}
}
