package org.springframework.social.tumblr.api;

import java.util.List;

public class Following {

    private int totalBlogs;
    private List<BlogInfo> blogs;

    public int getTotalBlogs() {
        return totalBlogs;
    }

    public void setTotalBlogs(int totalBlogs) {
        this.totalBlogs = totalBlogs;
    }

    public List<BlogInfo> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<BlogInfo> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Following{" +
                "totalBlogs=" + totalBlogs +
                ", blogs=" + blogs +
                '}';
    }
}
