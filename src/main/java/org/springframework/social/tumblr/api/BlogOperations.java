package org.springframework.social.tumblr.api;

public interface BlogOperations {

    BlogInfo info();

    String avatar(AvatarSize size);

    Followers followers();

    Followers followers(int offset, int limit);

    Likes likes();

    Likes likes(int offset, int limit);

    BlogPostOperations blogPostOperations();
    
    BlogPostsOperations blogPostsOperations();

}
