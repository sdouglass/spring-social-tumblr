package org.springframework.social.tumblr.api.impl;

import org.springframework.social.tumblr.api.*;
import org.springframework.social.tumblr.api.impl.json.BlogInfoResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BlogTemplate extends AbstractBlogOperations implements BlogOperations {

    public BlogTemplate(RestTemplate restTemplate, boolean isAuthorized, String apiKey, String blogHostname) {
        super(restTemplate, isAuthorized, apiKey, blogHostname);
    }

    public BlogInfo info() {
        requireApiKey();
        return getRestTemplate().getForObject(buildUri("info", "api_key", getApiKey()), BlogInfoResponse.class).getBlog();
    }

    public String avatar(AvatarSize size) {
        if (size == null) {
            throw new IllegalArgumentException("size must not be null");
        }
        URL url;
        try {
            url = buildUri("avatar/" + size.getDimension()).toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        HttpURLConnection httpURLConnection = null;
        String location = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.connect();
            location = httpURLConnection.getHeaderField("Location");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }
        return location;
    }

    public Followers followers() {
        return followers(0, 20);
    }

    public Followers followers(int offset, int limit) {
        requireAuthorization();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>(2);
        params.add("offset", Integer.toString(offset));
        params.add("limit", Integer.toString(limit));
        return getRestTemplate().getForObject(buildUri("followers", params), Followers.class);
    }

    @Override
    public Likes likes() {
        return likes(0, 20);
    }

    @Override
    public Likes likes(int offset, int limit) {
        requireApiKey();
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>(2);
        params.add("offset", Integer.toString(offset));
        params.add("limit", Integer.toString(limit));
        return getRestTemplate().getForObject(buildUri("likes", "api_key", getApiKey(), params), Likes.class);
    }

    public BlogPostOperations blogPostOperations() {
        return new BlogPostTemplate(getRestTemplate(), isAuthorized(), getApiKey(), getBlogHostname());
    }

    public BlogPostsOperations blogPostsOperations() {
        return new BlogPostsTemplate(getRestTemplate(), isAuthorized(), getApiKey(), getBlogHostname());
    }
}
