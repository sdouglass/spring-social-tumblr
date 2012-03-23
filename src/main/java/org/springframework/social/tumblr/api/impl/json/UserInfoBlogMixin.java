package org.springframework.social.tumblr.api.impl.json;

import org.codehaus.jackson.annotate.JsonProperty;

@SuppressWarnings("unused")
public class UserInfoBlogMixin {
	
  @JsonProperty("ask_anon")
  private boolean askAnon;

}
