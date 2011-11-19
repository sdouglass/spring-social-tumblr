package org.springframework.social.tumblr.api;

/**
 * @author sam
 * @version $Id$
 */
public interface BlogPostOperations {

    public void create(ModifyPost modifyPost);

    void edit(ModifyPost post);

    void reblog(ModifyReblogPost reblogPost);

    void delete(long id);
    
}
