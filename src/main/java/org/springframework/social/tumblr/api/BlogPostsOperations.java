package org.springframework.social.tumblr.api;

public interface BlogPostsOperations {

    Posts search(PostsQuery query);

    Posts queue();
    Posts queue(int limit, int offset, PostsQueryFilter filter);

    Posts draft();
    Posts draft(PostsQueryFilter filter);

    Posts submission();
    Posts submission(int offset, PostsQueryFilter filter);

}
