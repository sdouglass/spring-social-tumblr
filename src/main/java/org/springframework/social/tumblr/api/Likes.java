package org.springframework.social.tumblr.api;

import java.util.List;

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

    @Override
    public String toString() {
        return "Likes{" +
                "totalLikes=" + totalLikes +
                ", likedPosts=" + likedPosts +
                '}';
    }
}
