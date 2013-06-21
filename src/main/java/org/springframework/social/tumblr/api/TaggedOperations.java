package org.springframework.social.tumblr.api;

import java.util.List;

public interface TaggedOperations {

    List<Post> getTaggedPosts(TaggedPostsQuery query);
}
