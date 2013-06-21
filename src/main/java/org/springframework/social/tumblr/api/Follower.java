package org.springframework.social.tumblr.api;

public class Follower extends BaseEntity {

    private String name;
    private String url;
    private long updated;

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

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Follower{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", updated=" + updated +
                "} " + super.toString();
    }
}
