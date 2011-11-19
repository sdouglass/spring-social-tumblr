package org.springframework.social.tumblr.api.impl;

import org.springframework.social.tumblr.api.BlogPostOperations;
import org.springframework.social.tumblr.api.ModifyPost;
import org.springframework.social.tumblr.api.ModifyReblogPost;
import org.springframework.social.tumblr.api.impl.json.TumblrResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author sam
 * @version $Id$
 */
public class BlogPostTemplate extends AbstractBlogOperations implements BlogPostOperations {
    public BlogPostTemplate(RestTemplate restTemplate, boolean isAuthorized, String apiKey, String blogHostname) {
        super(restTemplate, isAuthorized, apiKey, blogHostname);
    }

    public void create(ModifyPost post) {
        requireAuthorization();
        MultiValueMap<String, String> map = post.toParameterMap();
        // get the response
        TumblrResponse response = getRestTemplate().postForObject(buildUri("post"), map, TumblrResponse.class);
        // remove non-digits
        String postIdString = response.getResponseJson().replaceAll("\\D+", "");
        // parse
        Long postId = Long.valueOf(postIdString);
        // set id of post
        post.setId(postId);
    }

    public void edit(ModifyPost post) {
        requireAuthorization();
        MultiValueMap<String, String> map = post.toParameterMap();
        // need to strip type? can't send type? don't know...???
//        map.remove("type");
        // don't care about response, already have id of post
        getRestTemplate().postForObject(buildUri("post/edit"), map, TumblrResponse.class);
    }

    public void reblog(ModifyReblogPost post) {
        requireAuthorization();
        MultiValueMap<String, String> map = post.toParameterMap();
        // need to strip type? can't send type? don't know...???
//        map.remove("type");
        // don't care about response, already have id of post
        getRestTemplate().postForObject(buildUri("post/reblog"), map, TumblrResponse.class);
    }

    public void delete(long id) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("id", id);
        // don't care about response
        getRestTemplate().postForObject(buildUri("post/delete"), map, TumblrResponse.class);
    }
}
