package org.springframework.social.tumblr.api.impl.json;


import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@SuppressWarnings("unused")
@JsonIgnoreProperties(ignoreUnknown=true) 
class BlogInfoMixin {

    @JsonProperty("ask_anon")
    private boolean askAnon;
    
    @JsonProperty("can_send_fan_mail")
    @JsonDeserialize(using = BooleanYNDeserializer.class)
    private boolean canSendFanMail;
}
