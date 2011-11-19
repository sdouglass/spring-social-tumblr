package org.springframework.social.tumblr.connect;

import org.springframework.social.oauth1.AbstractOAuth1ServiceProvider;
import org.springframework.social.oauth1.OAuth1Template;
import org.springframework.social.oauth1.OAuth1Version;
import org.springframework.social.tumblr.api.Tumblr;
import org.springframework.social.tumblr.api.impl.TumblrTemplate;

/**
 * Tumblr ServiceProvider implementation.
 * @author Sam Douglass
 */
public class TumblrServiceProvider extends AbstractOAuth1ServiceProvider<Tumblr> {

	public TumblrServiceProvider(String consumerKey, String consumerSecret) {
		super(consumerKey, consumerSecret, new OAuth1Template(consumerKey, consumerSecret,
			"https://www.tumblr.com/oauth/request_token",
			"https://www.tumblr.com/oauth/authorize",
			"https://www.tumblr.com/oauth/access_token",
            OAuth1Version.CORE_10_REVISION_A));
	}

	public Tumblr getApi(String accessToken, String secret) {
		return new TumblrTemplate(getConsumerKey(), getConsumerSecret(), accessToken, secret);
	}

}