package org.springframework.social.tumblr.api;

public interface BlogPostOperations {

    public void create(ModifyPost modifyPost);

    void edit(ModifyPost post);

    void reblog(ReblogPost reblogPost);

    void delete(long id);
    
}
