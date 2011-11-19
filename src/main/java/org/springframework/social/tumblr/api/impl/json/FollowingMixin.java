package org.springframework.social.tumblr.api.impl.json;

import org.codehaus.jackson.annotate.JsonProperty;
import org.springframework.social.tumblr.api.BlogInfo;

import java.util.List;

/**
 * @author sam
 * @version $Id$
 */
@SuppressWarnings("unused")
class FollowingMixin {

    @JsonProperty("total_blogs")
    private int totalBlogs;

}
