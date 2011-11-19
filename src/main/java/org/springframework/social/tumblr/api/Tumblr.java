package org.springframework.social.tumblr.api;

/**
 * @author sam
 * @version $Id$
 */
public interface Tumblr {

    BlogOperations blogOperations(String blogHostname);
    
    UserOperations userOperations();
}
