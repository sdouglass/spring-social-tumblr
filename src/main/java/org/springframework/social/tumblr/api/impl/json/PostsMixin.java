package org.springframework.social.tumblr.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.tumblr.api.BlogInfo;

@SuppressWarnings("unused")
class PostsMixin {

    @JsonProperty("blog")
    private BlogInfo blogInfo;
    
    @JsonProperty("total_posts")
    private int totalPosts;

//    @JsonProperty("posts")
//    private List<Post> posts;
}
