package org.springframework.social.tumblr.api;

public class VideoPostPlayer {

    private int width;
    private String embedCode;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getEmbedCode() {
        return embedCode;
    }

    public void setEmbedCode(String embedCode) {
        this.embedCode = embedCode;
    }
}
