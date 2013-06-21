package org.springframework.social.tumblr.api.impl;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.tumblr.api.BlogOperations;
import org.springframework.social.tumblr.api.TaggedOperations;
import org.springframework.social.tumblr.api.Tumblr;
import org.springframework.social.tumblr.api.UserOperations;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class TumblrTemplate extends AbstractOAuth1ApiBinding implements Tumblr {

    private String apiKey;

    private UserOperations userOperations;

    private TaggedOperations taggedOperations;

    private TumblrOAuth1Credentials credentials;

    public TumblrTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        this.apiKey = consumerKey;
        credentials = new TumblrOAuth1Credentials(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        initApis();
    }
    
    public TumblrTemplate(String consumerKey) {
        super();
        this.apiKey = consumerKey;
        initApis();
    }

    public TumblrOAuth1Credentials getCredentials() {
        return credentials;
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
        List<HttpMessageConverter<?>> oldMessageConverters = restTemplate.getMessageConverters();
        for (HttpMessageConverter<?> converter : oldMessageConverters) {
            if (converter instanceof FormHttpMessageConverter) {
                // use LATIN1 character set for all form posts...?
                ((FormHttpMessageConverter) converter).setCharset(Charset.forName("LATIN1"));
            }
        }
        // replace the default OAuth1 interceptor with a custom one that uses a custom SigningSupport impl
        // doing some hokey stuff here to make the credentials available to the interceptor
        TumblrOAuth1RequestInterceptor interceptor = new TumblrOAuth1RequestInterceptor(this);
        List<ClientHttpRequestInterceptor> newInterceptors = new ArrayList<ClientHttpRequestInterceptor>();
        newInterceptors.add(interceptor);
        restTemplate.setInterceptors(newInterceptors);
    }

    @Override
    protected MappingJacksonHttpMessageConverter getJsonMessageConverter() {
        return new TumblrHttpMessageConverter();
    }

    public BlogOperations blogOperations(String blogHostname) {
        return new BlogTemplate(getRestTemplate(), isAuthorized(), apiKey, blogHostname);
    }

    public UserOperations userOperations() {
        return userOperations;
    }

    public TaggedOperations taggedOperations() {
        return taggedOperations;
    }

    private void initApis() {
        this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized(), apiKey);
        this.taggedOperations = new TaggedOperationsTemplate(getRestTemplate(), isAuthorized(), apiKey);
    }
}
