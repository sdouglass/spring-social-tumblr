package org.springframework.social.tumblr.api.impl.json;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

@SuppressWarnings("unused")
public class UserInfoBlogMixin {
	
  @JsonProperty("ask_anon")
  private boolean askAnon;
  
  @JsonProperty("facebook_opengraph_enabled")
  @JsonDeserialize(using = BooleanYNDeserializer.class)
  private boolean facebookOpengraphEnabled;



}
