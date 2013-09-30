package org.springframework.social.tumblr.security;

import org.springframework.social.connect.support.OAuth1ConnectionFactory;
import org.springframework.social.security.provider.OAuth1AuthenticationService;
import org.springframework.social.tumblr.api.Tumblr;

public class TumblrAuthenticationService extends OAuth1AuthenticationService<Tumblr> {

    public TumblrAuthenticationService(OAuth1ConnectionFactory<Tumblr> connectionFactory) {
        super(connectionFactory);
    }
}
