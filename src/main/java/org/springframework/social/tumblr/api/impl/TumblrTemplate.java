package org.springframework.social.tumblr.api.impl;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
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

    /**
     * Constructor to make unauthenticated calls to Tumblr's public API methods.
     */
    public TumblrTemplate() {
        super();
        initApis();
    }

    /**
     * Constructor to make calls to Tumblr's API methods that require an API key.
     *
     * @param consumerKey your Tumblr app's API key
     */
    public TumblrTemplate(String consumerKey) {
        super();
        this.apiKey = consumerKey;
        initApis();
    }

    /**
     * Constructor to make calls to Tubmlr's API on behalf of a Tumblr user.
     *
     * @param consumerKey your Tumblr app's API key
     * @param consumerSecret your Tumblr app's secret
     * @param accessToken the access token your app has been granted for a particular user
     * @param accessTokenSecret the access token secret your app has been granted for a particular user
     */
    public TumblrTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        this.apiKey = consumerKey;
        credentials = new TumblrOAuth1Credentials(consumerKey, consumerSecret, accessToken, accessTokenSecret);
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
    protected MappingJackson2HttpMessageConverter getJsonMessageConverter() {
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
