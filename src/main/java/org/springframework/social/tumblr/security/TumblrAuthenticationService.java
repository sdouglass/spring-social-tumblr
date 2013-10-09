package org.springframework.social.tumblr.security;

import org.springframework.social.security.provider.OAuth1AuthenticationService;
import org.springframework.social.tumblr.api.Tumblr;
import org.springframework.social.tumblr.connect.TumblrConnectionFactory;

public class TumblrAuthenticationService extends OAuth1AuthenticationService<Tumblr> {

    public TumblrAuthenticationService(String apiKey, String appSecret) {
        super(new TumblrConnectionFactory(apiKey, appSecret));
    }
}
