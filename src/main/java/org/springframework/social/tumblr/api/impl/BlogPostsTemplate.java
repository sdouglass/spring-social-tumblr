package org.springframework.social.tumblr.api.impl;

import org.springframework.social.tumblr.api.BlogPostsOperations;
import org.springframework.social.tumblr.api.Posts;
import org.springframework.social.tumblr.api.PostsQuery;
import org.springframework.web.client.RestTemplate;

public class BlogPostsTemplate extends AbstractBlogOperations implements BlogPostsOperations {
    public BlogPostsTemplate(RestTemplate restTemplate, boolean isAuthorized, String apiKey, String blogHostname) {
        super(restTemplate, isAuthorized, apiKey, blogHostname);
    }

    public Posts search(PostsQuery query) {
        requireApiKey();
        if (query == null) {
            query = new PostsQuery();
        }
        return getRestTemplate().getForObject(buildUri("posts", "api_key", getApiKey()).toString(), Posts.class, query.toParameterMap());
    }

    public Posts queue() {
        requireAuthorization();
        return getRestTemplate().postForObject(buildUri("posts/queue"), null, Posts.class);
    }

    public Posts draft() {
        requireAuthorization();
        return getRestTemplate().postForObject(buildUri("posts/draft"), null, Posts.class);
    }

    public Posts submission() {
        requireAuthorization();
        return getRestTemplate().postForObject(buildUri("posts/submission"), null, Posts.class);
    }
}
