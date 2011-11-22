package org.springframework.social.tumblr.api.impl;

/**
 * Bean for OAuth credentials. Copy of Spring Socials' OAuth1Credentials, which is not public.
 *
 * @author sam
 * @version $Id$
 */
public class TumblrOAuth1Credentials {
    private final String consumerKey;

    private final String consumerSecret;

    private final String accessToken;

    private final String accessTokenSecret;

    public TumblrOAuth1Credentials(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
    }

    public String getConsumerKey() {
        return consumerKey;
    }

    public String getConsumerSecret() {
        return consumerSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }
}
