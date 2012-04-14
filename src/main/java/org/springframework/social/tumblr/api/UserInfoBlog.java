package org.springframework.social.tumblr.api;

import java.util.Date;

/**
 * @author sam
 * @version $Id$
 */
public class UserInfoBlog {

    private String name;
    private String url;
    private String title;
    private boolean ask;
    private boolean askAnon;
    private boolean facebookOpengraphEnabled;
		private int followers;
    private boolean primary;
    private boolean admin;
    private int queue;
    private String tweet; // number: indicate if posts are tweeted auto, Y, N
    private String description;
    private Date updated;
    private int posts;
    private int blogs;
    private int drafts;
    private int messages;
	private String type;
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public boolean isAsk() {
        return ask;
    }

    public void setAsk(boolean ask) {
        this.ask = ask;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
    
    public boolean isAskAnon() {
      return askAnon;
    }

    public void setAskAnon(boolean askAnon) {
      this.ask = askAnon;
    }
  
    public boolean isFacebookOpengraphEnabled() {
    	return facebookOpengraphEnabled;
    }

    public void setFacebookOpengraphEnabled(boolean facebookOpengraphEnabled) {
    	this.facebookOpengraphEnabled = facebookOpengraphEnabled;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public int getPosts() {
		return posts;
	}

	public void setPosts(int posts) {
		this.posts = posts;
	}

	public int getBlogs() {
		return blogs;
	}

	public void setBlogs(int blogs) {
		this.blogs = blogs;
	}

	public int getDrafts() {
		return drafts;
	}

	public void setDrafts(int drafts) {
		this.drafts = drafts;
	}

	public int getMessages() {
		return messages;
	}

	public void setMessages(int messages) {
		this.messages = messages;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
}
