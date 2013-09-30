package org.springframework.social.tumblr.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
public class UserInfoBlogMixin {

  @JsonProperty("ask_anon")
  private boolean askAnon;
  
  @JsonProperty("facebook_opengraph_enabled")
  @JsonDeserialize(using = BooleanYNDeserializer.class)
  private boolean facebookOpengraphEnabled;

  @JsonProperty("facebook")
  @JsonDeserialize(using = BooleanYNDeserializer.class)
  private boolean facebook;


}
