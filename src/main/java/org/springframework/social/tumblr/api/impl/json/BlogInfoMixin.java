package org.springframework.social.tumblr.api.impl.json;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
class BlogInfoMixin {

    @JsonProperty("ask_anon")
    private boolean askAnon;

    @JsonProperty("share_likes")
    private boolean shareLikes;

    @JsonProperty("is_nsfw")
    private boolean nsfw;

    @JsonProperty("can_send_fan_mail")
    @JsonDeserialize(using = BooleanYNDeserializer.class)
    private boolean canSendFanMail;
}
