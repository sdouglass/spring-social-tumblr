package org.springframework.social.tumblr.api.impl.json;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.module.SimpleModule;
import org.springframework.social.tumblr.api.*;

public class TumblrModule extends SimpleModule {
    public TumblrModule() {
        super("TumblrModule", new Version(1, 0, 0, null));
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(TumblrResponse.class, TumblrResponseMixin.class);
        context.setMixInAnnotations(UserInfo.class, UserInfoMixin.class);
        context.setMixInAnnotations(UserInfoBlog.class, UserInfoBlogMixin.class);
        context.setMixInAnnotations(BlogInfo.class, BlogInfoMixin.class);
        context.setMixInAnnotations(Followers.class, FollowersMixin.class);
        context.setMixInAnnotations(Following.class, FollowingMixin.class);
        context.setMixInAnnotations(Posts.class, PostsMixin.class);
        context.setMixInAnnotations(Post.class, PostMixin.class);
        context.setMixInAnnotations(Likes.class, LikesMixin.class);
    }
}
