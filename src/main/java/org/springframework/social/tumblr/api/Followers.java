package org.springframework.social.tumblr.api;

import java.util.ArrayList;
import java.util.List;

public class Followers {

    private int totalFollowers;
    private List<Follower> followers = new ArrayList<Follower>();

    public int getTotalFollowers() {
        return totalFollowers;
    }

    public void setTotalFollowers(int totalFollowers) {
        this.totalFollowers = totalFollowers;
    }

    public List<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Follower> followers) {
        this.followers = followers;
    }

    @Override
    public String toString() {
        return "Followers{" +
                "totalFollowers=" + totalFollowers +
                ", followers=" + followers +
                '}';
    }
}
