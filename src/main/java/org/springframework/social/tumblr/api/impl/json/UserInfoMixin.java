package org.springframework.social.tumblr.api.impl.json;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@SuppressWarnings("unused")
class UserInfoMixin {

    @JsonProperty("default_post_format")
    private String defaultPostFormat;
    
}
