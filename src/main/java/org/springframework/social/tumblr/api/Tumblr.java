package org.springframework.social.tumblr.api;

public interface Tumblr {

    BlogOperations blogOperations(String blogHostname);
    
    UserOperations userOperations();

    TaggedOperations taggedOperations();
}
