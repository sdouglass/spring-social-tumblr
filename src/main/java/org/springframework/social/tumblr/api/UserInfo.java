package org.springframework.social.tumblr.api;

import java.util.List;

public class UserInfo extends BaseEntity {

    private int following;
    private String defaultPostFormat;
    private String name;
    private int likes;
    private List<UserInfoBlog> blogs;

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public String getDefaultPostFormat() {
        return defaultPostFormat;
    }

    public void setDefaultPostFormat(String defaultPostFormat) {
        this.defaultPostFormat = defaultPostFormat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public List<UserInfoBlog> getBlogs() {
        return blogs;
    }
    
    public void setBlogs(List<UserInfoBlog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "following=" + following +
                ", defaultPostFormat='" + defaultPostFormat + '\'' +
                ", name='" + name + '\'' +
                ", likes=" + likes +
                ", blogs=" + blogs +
                "} " + super.toString();
    }
}
