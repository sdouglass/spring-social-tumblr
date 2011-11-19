package org.springframework.social.tumblr.api.impl;

import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.tumblr.api.BlogOperations;
import org.springframework.social.tumblr.api.Tumblr;
import org.springframework.social.tumblr.api.UserOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author sam
 * @version $Id$
 */
public class TumblrTemplate extends AbstractOAuth1ApiBinding implements Tumblr {

    private String apiKey;

    private UserOperations userOperations;

    public TumblrTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
        this.apiKey = consumerKey;
        initApis();
    }

    @Override
    protected void configureRestTemplate(RestTemplate restTemplate) {
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

    private void initApis() {
        this.userOperations = new UserTemplate(getRestTemplate(), isAuthorized(), apiKey);
    }
}
