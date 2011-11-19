package org.springframework.social.tumblr.api;

import java.util.List;

/**
 * @author sam
 * @version $Id$
 */
public class Likes {

    private int totalLikes;

    private List<Post> likedPosts;

    public int getTotalLikes() {
        return totalLikes;
    }

    public void setTotalLikes(int totalLikes) {
        this.totalLikes = totalLikes;
    }

    public List<Post> getLikedPosts() {
        return likedPosts;
    }

    public void setLikedPosts(List<Post> likedPosts) {
        this.likedPosts = likedPosts;
    }
}
