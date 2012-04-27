package org.springframework.social.tumblr.api.impl.json;

import org.springframework.social.tumblr.api.UserInfo;

@SuppressWarnings("unused")
public class UserInfoResponse {

    private UserInfo user;

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }
}
