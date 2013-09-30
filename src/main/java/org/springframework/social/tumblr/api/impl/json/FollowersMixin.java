package org.springframework.social.tumblr.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.tumblr.api.Follower;

import java.util.List;

@SuppressWarnings("unused")
class FollowersMixin {

    @JsonProperty("total_users")
    private int totalFollowers;

    @JsonProperty("users")
    private List<Follower> followers;
}
