package org.springframework.social.tumblr.api;

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
    private int followers;
    private boolean primary;
    private boolean admin;
    private int queue;
    private String tweet; // number: indicate if posts are tweeted auto, Y, N

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
}
