package org.springframework.social.tumblr.api;

/**
 * @author sam
 * @version $Id$
 */
public enum PostState {
    PUBLISHED("published"),
    DRAFT("draft"),
    QUEUE("queue");

    private String state;

    PostState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
