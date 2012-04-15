package org.springframework.social.tumblr.api.impl.json;

import org.codehaus.jackson.annotate.JsonProperty;

@SuppressWarnings("unused")
class UserInfoMixin {

    @JsonProperty("default_post_format")
    private String defaultPostFormat;
}
