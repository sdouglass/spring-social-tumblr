package org.springframework.social.tumblr.api.impl.json;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.tumblr.api.Follower;

import java.util.List;

/**
 * @author sam
 * @version $Id$
 */
@SuppressWarnings("unused")
class FollowersMixin {

    @JsonProperty("total_users")
    private int totalFollowers;

    @JsonProperty("users")
    private List<Follower> followers;
}
