package org.springframework.social.tumblr.api.impl.json;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author sam
 * @version $Id$
 */
@SuppressWarnings("unused")
class UserInfoMixin {

    @JsonProperty("default_post_format")
    private String defaultPostFormat;
}
