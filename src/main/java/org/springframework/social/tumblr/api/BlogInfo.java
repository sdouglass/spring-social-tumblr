package org.springframework.social.tumblr.api;

public class BlogInfo {

    private String name;
    private String url;
    private String title;
    private boolean ask;
    private boolean askAnon;
    private int posts;
    private long updated;
    private String description;
    private int likes;
    private boolean followed;
    private boolean canSendFanMail;
    

	public boolean isCanSendFanMail() {
		return canSendFanMail;
	}

	public void setCanSendFanMail(boolean canSendFanMail) {
		this.canSendFanMail = canSendFanMail;
	}

	public boolean isFollowed() {
		return followed;
	}

	public void setFollowed(boolean followed) {
		this.followed = followed;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPosts() {
        return posts;
    }

    public void setPosts(int posts) {
        this.posts = posts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAsk() {
        return ask;
    }

    public void setAsk(boolean ask) {
        this.ask = ask;
    }

    public boolean isAskAnon() {
        return askAnon;
    }

    public void setAskAnon(boolean askAnon) {
        this.askAnon = askAnon;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
