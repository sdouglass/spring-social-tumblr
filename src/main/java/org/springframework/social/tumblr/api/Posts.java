package org.springframework.social.tumblr.api;

import java.util.List;

public class Posts {

    private BlogInfo blogInfo;

    private int totalPosts;

    private List<Post> posts;

    public BlogInfo getBlogInfo() {
        return blogInfo;
    }

    public void setBlogInfo(BlogInfo blogInfo) {
        this.blogInfo = blogInfo;
    }

    public int getTotalPosts() {
        return totalPosts;
    }

    public void setTotalPosts(int totalPosts) {
        this.totalPosts = totalPosts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "blogInfo=" + blogInfo +
                ", totalPosts=" + totalPosts +
                ", posts=" + posts +
                '}';
    }
}
