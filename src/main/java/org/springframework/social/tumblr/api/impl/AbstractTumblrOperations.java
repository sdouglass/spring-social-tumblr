package org.springframework.social.tumblr.api.impl;

import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.support.URIBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

class AbstractTumblrOperations {

    private final RestTemplate restTemplate;
    private final boolean isAuthorized;
    private final String apiKey;

    public AbstractTumblrOperations(RestTemplate restTemplate, boolean isAuthorized, String apiKey) {
        this.restTemplate = restTemplate;
        this.isAuthorized = isAuthorized;
        this.apiKey = apiKey;
    }

    protected void requireAuthorization() {
        if (!isAuthorized) {
            throw new MissingAuthorizationException("Authorization missing");
        }
    }

    protected void requireApiKey() {
        if (apiKey == null) {
            throw new MissingAuthorizationException("Authorization missing");
        }
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public String getApiKey() {
        return apiKey;
    }

    protected URI buildUri(String path) {
        return buildUri(path, EMPTY_PARAMETERS);
    }

    protected URI buildUri(String path, String parameterName, String parameterValue) {
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
        parameters.set(parameterName, parameterValue);
        return buildUri(path, parameters);
    }

    protected URI buildUri(String path, MultiValueMap<String, String> parameters) {
        return URIBuilder.fromUri(API_URL_BASE + path).queryParams(parameters).build();
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    private static final String API_URL_BASE = "http://api.tumblr.com/v2/";

    static final LinkedMultiValueMap<String, String> EMPTY_PARAMETERS = new LinkedMultiValueMap<String, String>();
}
