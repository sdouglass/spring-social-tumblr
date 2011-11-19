package org.springframework.social.tumblr.api.impl.json;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.tumblr.api.BlogInfo;
import org.springframework.social.tumblr.api.Follower;
import org.springframework.social.tumblr.api.Post;

import java.util.List;

/**
 * @author sam
 * @version $Id$
 */
@SuppressWarnings("unused")
class PostsMixin {

    @JsonProperty("blog")
    private BlogInfo blogInfo;
    
    @JsonProperty("total_posts")
    private int totalPosts;

//    @JsonProperty("posts")
//    private List<Post> posts;
}
