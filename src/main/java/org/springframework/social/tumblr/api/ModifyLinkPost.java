package org.springframework.social.tumblr.api;

import org.springframework.util.MultiValueMap;

public class ModifyLinkPost extends ModifyPost {

    private String url;
    private String title;
    private String description;

    public ModifyLinkPost() {
        super(PostType.LINK);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public MultiValueMap<String, String> toParameterMap() {
        MultiValueMap<String, String> map = super.toParameterMap();

        map.add("url", url);

        if (title != null) {
            map.add("title", title);
        }

        if (description != null) {
            map.add("description", description);
        }

        return map;
    }
}
