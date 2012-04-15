package org.springframework.social.tumblr.api;

public interface BlogPostsOperations {

    Posts search(PostsQuery query);

    Posts queue();

    Posts draft();

    Posts submission();
    
}
