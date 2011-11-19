package org.springframework.social.tumblr.api;

/**
 * @author sam
 * @version $Id$
 */
public interface BlogOperations {

    BlogInfo info();

    String avatar(AvatarSize size);

    Followers followers();

    Followers followers(int offset, int limit);

    BlogPostOperations blogPostOperations();
    
    BlogPostsOperations blogPostsOperations();

}
