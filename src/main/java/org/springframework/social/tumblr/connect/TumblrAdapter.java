/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.tumblr.connect;

import org.springframework.social.ApiException;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.tumblr.api.Tumblr;
import org.springframework.social.tumblr.api.UserInfo;

/**
 * Tumblr ApiAdapter implementation.
 * @author Sam Douglass
 */
public class TumblrAdapter implements ApiAdapter<Tumblr> {

	public boolean test(Tumblr tumblr) {
		try {
			tumblr.userOperations().info();
			return true;
		} catch (ApiException e) {
			return false;
		}
	}

	public void setConnectionValues(Tumblr tumblr, ConnectionValues values) {
		UserInfo profile = tumblr.userOperations().info();
        // tumblr API doesn't seem to provide any of this data...?
        // use profile.getName() ("short name") for id for now
		values.setProviderUserId(profile.getName());
		values.setDisplayName(profile.getName());
        // this might not be right if user has a custom domain
//		values.setProfileUrl("http://"+profile.getName()+".tumblr.com/");
		values.setProfileUrl(null);
		values.setImageUrl(null);
	}

    public UserProfile fetchUserProfile(Tumblr tumblr) {
		UserInfo profile = tumblr.userOperations().info();
		return new UserProfileBuilder().setUsername(profile.getName()).build();
	}
	
	public void updateStatus(Tumblr tumblr, String message) {
		throw new UnsupportedOperationException("cannot update status of Tumblr account");
	}
	
}