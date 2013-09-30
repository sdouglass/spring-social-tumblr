package org.springframework.social.tumblr.api.impl;

import org.springframework.social.tumblr.api.*;
import org.springframework.social.tumblr.api.impl.json.TumblrResponse;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class BlogPostTemplate extends AbstractBlogOperations implements BlogPostOperations {
    public BlogPostTemplate(RestTemplate restTemplate, boolean isAuthorized, String apiKey, String blogHostname) {
        super(restTemplate, isAuthorized, apiKey, blogHostname);
    }

    public void create(ModifyPost post) {
        if (post == null) {
            throw new IllegalArgumentException("post must not be null");
        }
        if (post.getType() == null) {
            throw new IllegalArgumentException("type must not be null");
        }
        switch (post.getType()) {
            case TEXT:
                ModifyTextPost textPost = (ModifyTextPost) post;
                if (textPost.getBody() == null) {
                    throw new IllegalArgumentException("body must not be null for text posts");
                }
                break;
            case PHOTO:
                ModifyPhotoPost photoPost = (ModifyPhotoPost) post;
                if (photoPost.getData() == null && photoPost.getSource() == null) {
                    throw new IllegalArgumentException("data or source must not be null for photo posts");
                }
                break;
            case QUOTE:
                ModifyQuotePost quotePost = (ModifyQuotePost) post;
                if (quotePost.getQuote() == null) {
                    throw new IllegalArgumentException("quote must not be null for quote posts");
                }
                break;
            case LINK:
                ModifyLinkPost linkPost = (ModifyLinkPost) post;
                if (linkPost.getUrl() == null) {
                    throw new IllegalArgumentException("url must not be null for link posts");
                }
                break;
            case CHAT:
                ModifyChatPost chatPost = (ModifyChatPost) post;
                if (chatPost.getConversation() == null) {
                    throw new IllegalArgumentException("conversation must not be null for chat posts");
                }
                break;
            case AUDIO:
                ModifyAudioPost audioPost = (ModifyAudioPost) post;
                if (audioPost.getData() == null && audioPost.getExternalUrl() == null) {
                    throw new IllegalArgumentException("data or external url must not be null for audio posts");
                }
                break;
            case VIDEO:
                ModifyVideoPost videoPost = (ModifyVideoPost) post;
                if (videoPost.getData() == null && videoPost.getEmbed() == null) {
                    throw new IllegalArgumentException("data or embed must not be null for video posts");
                }
                break;
        }
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
        // don't care about response, already have id of post
        getRestTemplate().postForObject(buildUri("post/edit"), map, TumblrResponse.class);
    }

    public void reblog(ReblogPost post) {
        if (post == null) {
            throw new IllegalArgumentException("post must not be null");
        }
        if (post.getId() == null) {
            throw new IllegalArgumentException("post id must not be null");
        }
        if (post.getReblogKey() == null) {
            throw new IllegalArgumentException("reblog key must not be null");
        }
        requireAuthorization();
        MultiValueMap<String, String> map = post.toParameterMap();
        // don't care about response, already have id of post
        getRestTemplate().postForObject(buildUri("post/reblog"), map, TumblrResponse.class);
    }

    public void delete(long id) {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
        map.add("id", Long.toString(id));
        // don't care about response
        getRestTemplate().postForObject(buildUri("post/delete"), map, TumblrResponse.class);
    }
}
