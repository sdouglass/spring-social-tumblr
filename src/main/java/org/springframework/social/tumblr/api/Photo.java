package org.springframework.social.tumblr.api;

import java.util.List;

public class Photo extends BaseEntity {

    private String caption;
    private List<PhotoSize> sizes;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public List<PhotoSize> getSizes() {
        return sizes;
    }

    public void setSizes(List<PhotoSize> sizes) {
        this.sizes = sizes;
    }
}
