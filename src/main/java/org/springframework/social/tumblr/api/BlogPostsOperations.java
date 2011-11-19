package org.springframework.social.tumblr.api;

/**
 * @author sam
 * @version $Id$
 */
public interface BlogPostsOperations {

    Posts search(PostsQuery query);

    Posts queue();

    Posts draft();

    Posts submission();
    
}
