package org.springframework.social.tumblr.api.impl;

import org.springframework.social.tumblr.api.Post;
import org.springframework.social.tumblr.api.Posts;
import org.springframework.social.tumblr.api.TaggedOperations;
import org.springframework.social.tumblr.api.TaggedPostsQuery;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class TaggedOperationsTemplate extends AbstractTumblrOperations implements TaggedOperations {
    public TaggedOperationsTemplate(RestTemplate restTemplate, boolean isAuthorized, String apiKey) {
        super(restTemplate, isAuthorized, apiKey);
    }

    @Override
    public List<Post> getTaggedPosts(TaggedPostsQuery query) {
        requireApiKey();
        if (query == null) {
            query = new TaggedPostsQuery();
        }
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        params.add("api_key", getApiKey());
        params.putAll(query.toParameterMap());
        Post[] posts = getRestTemplate().getForObject(buildUri("tagged", params).toString(), Post[].class);
        return Arrays.asList(posts);
    }
}
