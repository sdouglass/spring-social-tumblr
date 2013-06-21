package org.springframework.social.tumblr.api.impl;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

public class AbstractBlogOperations extends AbstractTumblrOperations {

    private String blogHostname;

    public AbstractBlogOperations(RestTemplate restTemplate, boolean isAuthorized, String apiKey, String blogHostname) {
        super(restTemplate, isAuthorized, apiKey);
        this.blogHostname = blogHostname;
    }

    protected String makeFullPath(String path) {
        return "blog/" + blogHostname + "/" + path;
    }

    @Override
    protected URI buildUri(String path) {
        return super.buildUri(makeFullPath(path), AbstractTumblrOperations.EMPTY_PARAMETERS);
    }

    @Override
    protected URI buildUri(String path, String parameterName, String parameterValue) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set(parameterName, parameterValue);
        return super.buildUri(makeFullPath(path), parameters);
    }
    
    protected URI buildUri(String path, String parameterName, String parameterValue, MultiValueMap<String, String> additionalParameters) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set(parameterName, parameterValue);
        parameters.putAll(additionalParameters);
        return super.buildUri(makeFullPath(path), parameters);
    }

    @Override
    protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
        return super.buildUri(makeFullPath(path), parameters);
    }

    public String getBlogHostname() {
        return blogHostname;
    }
}
