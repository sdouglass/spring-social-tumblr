package org.springframework.social.tumblr.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
class FollowingMixin {

    @JsonProperty("total_blogs")
    private int totalBlogs;

}
