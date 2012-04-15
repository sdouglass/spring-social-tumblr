package org.springframework.social.tumblr.api.impl.json;

import org.springframework.social.tumblr.api.BlogInfo;

@SuppressWarnings("unused")
public class BlogInfoResponse {

    private BlogInfo blog;

    public BlogInfo getBlog() {
        return blog;
    }

    public void setBlog(BlogInfo blog) {
        this.blog = blog;
    }
}
