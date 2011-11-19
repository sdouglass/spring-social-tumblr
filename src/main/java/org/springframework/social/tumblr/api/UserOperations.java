package org.springframework.social.tumblr.api;

/**
 * @author sam
 * @version $Id$
 */
public interface UserOperations {

    UserInfo info();

    Posts dashboard();

    Posts dashboard(PostsQuery query);

    Likes likes();

    Likes likes(int offset, int limit);

    Following following();

    Following following(int offset, int limit);

    void follow(String blogUrl);

    void unfollow(String blogUrl);

    void like(long id, String reblogKey);

    void unlike(long id, String reblogKey);
    
}
