package org.springframework.social.tumblr.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("unused")
class UserInfoMixin {

    @JsonProperty("default_post_format")
    private String defaultPostFormat;
    
}
