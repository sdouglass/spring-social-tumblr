package org.springframework.social.tumblr.api.impl.json;


import org.codehaus.jackson.annotate.JsonProperty;

@SuppressWarnings("unused")
class BlogInfoMixin {

    @JsonProperty("ask_anon")
    private boolean askAnon;
}
