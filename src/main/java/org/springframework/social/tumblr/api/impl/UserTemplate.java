package org.springframework.social.tumblr.api.impl;

import org.springframework.social.tumblr.api.*;
import org.springframework.social.tumblr.api.impl.json.TumblrResponse;
import org.springframework.social.tumblr.api.impl.json.UserInfoResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author sam
 * @version $Id$
 */
public class UserTemplate extends AbstractTumblrOperations implements UserOperations {

    public UserTemplate(RestTemplate restTemplate, boolean isAuthorized, String apiKey) {
        super(restTemplate, isAuthorized, apiKey);
    }

    public UserInfo info() {
        requireAuthorization();
        return getRestTemplate().getForObject(buildUri("user/info"), UserInfoResponse.class).getUser();
    }

    public Posts dashboard() {
        return dashboard(new PostsQuery());
    }

    public Posts dashboard(PostsQuery query) {
        requireAuthorization();
        return getRestTemplate().getForObject(buildUri("user/dashboard").toString(), Posts.class, query.toParameterMap());
    }

    public Likes likes() {
        return likes(0, 20);
    }

    public Likes likes(int offset, int limit) {
        requireAuthorization();
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
        params.add("offset", offset);
        params.add("limit", limit);
        return getRestTemplate().getForObject(buildUri("user/likes").toString(), Likes.class, params);
    }

    public Following following() {
        return following(0, 20);
    }

    public Following following(int offset, int limit) {
        requireAuthorization();
        return getRestTemplate().getForObject(buildUri("user/following"), Following.class);
    }

    public void follow(String blogUrl) {
        requireAuthorization();
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("url", blogUrl);
        // should either error or not
        getRestTemplate().postForObject(buildUri("user/follow"), map, TumblrResponse.class);
    }

    public void unfollow(String blogUrl) {
        requireAuthorization();
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("url", blogUrl);
        // should either error or not
        getRestTemplate().postForObject(buildUri("user/unfollow"), map, TumblrResponse.class);
    }

    public void like(long id, String reblogKey) {
        requireAuthorization();
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("id", id);
        map.add("reblog_key", reblogKey);
        // should either error or not
        getRestTemplate().postForObject(buildUri("user/like"), map, TumblrResponse.class);
    }

    public void unlike(long id, String reblogKey) {
        requireAuthorization();
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("id", id);
        map.add("reblog_key", reblogKey);
        // should either error or not
        getRestTemplate().postForObject(buildUri("user/unlike"), map, TumblrResponse.class);
    }
}
