package org.springframework.social.tumblr.api;

import org.springframework.util.MultiValueMap;

public class ModifyTextPost extends ModifyPost {

    private String title;
    private String body;

    public ModifyTextPost() {
        super(PostType.TEXT);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public MultiValueMap<String, String> toParameterMap() {
        MultiValueMap<String, String> map = super.toParameterMap();
        
        if (getTitle() != null) {
            map.add("title", getTitle());
        }
        map.add("body", getBody());        
        
        return map;
    }
}
