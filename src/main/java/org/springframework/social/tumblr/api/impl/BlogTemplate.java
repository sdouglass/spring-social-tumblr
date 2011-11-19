package org.springframework.social.tumblr.api.impl;

import org.springframework.http.HttpHeaders;
import org.springframework.social.tumblr.api.*;
import org.springframework.social.tumblr.api.impl.json.BlogInfoResponse;
import org.springframework.web.client.RestTemplate;

/**
 * @author sam
 * @version $Id$
 */
public class BlogTemplate extends AbstractBlogOperations implements BlogOperations {

    public BlogTemplate(RestTemplate restTemplate, boolean isAuthorized, String apiKey, String blogHostname) {
        super(restTemplate, isAuthorized, apiKey, blogHostname);
    }

    public BlogInfo info() {
        requireApiKey();
        return getRestTemplate().getForObject(buildUri("info", "api_key", getApiKey()), BlogInfoResponse.class).getBlog();
    }

    public String avatar(AvatarSize size) {
        HttpHeaders headers = getRestTemplate().headForHeaders(buildUri("avatar/" + size.getDimension()));
        return headers.getLocation().toString();
    }

    public Followers followers() {
        return followers(0, 20);
    }

    public Followers followers(int offset, int limit) {
        requireAuthorization();
        return getRestTemplate().getForObject(buildUri("followers"), Followers.class);
    }

    public BlogPostOperations blogPostOperations() {
        return new BlogPostTemplate(getRestTemplate(), isAuthorized(), getApiKey(), getBlogHostname());
    }

    public BlogPostsOperations blogPostsOperations() {
        return new BlogPostsTemplate(getRestTemplate(), isAuthorized(), getApiKey(), getBlogHostname());
    }
}
