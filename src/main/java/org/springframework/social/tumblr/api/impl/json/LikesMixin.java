package org.springframework.social.tumblr.api.impl.json;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.tumblr.api.Post;

import java.util.List;

@SuppressWarnings("unused")
class LikesMixin {

    @JsonProperty("liked_count")
    private int totalLikes;

    @JsonProperty("liked_posts")
    private List<Post> likedPosts;

}
