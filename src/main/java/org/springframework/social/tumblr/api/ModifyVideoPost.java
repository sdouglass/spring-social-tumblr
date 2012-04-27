package org.springframework.social.tumblr.api;

import org.springframework.core.io.Resource;
import org.springframework.util.MultiValueMap;

public class ModifyVideoPost extends ModifyPost {

    private String embed;
    private Resource data;
    private String caption;

    public ModifyVideoPost() {
        super(PostType.VIDEO);
    }

    public String getEmbed() {
        return embed;
    }

    public void setEmbed(String embed) {
        this.embed = embed;
    }

    public Resource getData() {
        return data;
    }

    public void setData(Resource data) {
        this.data = data;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    @Override
    public MultiValueMap<String, String> toParameterMap() {
        MultiValueMap<String, String> map = super.toParameterMap();

        if (embed != null) {
            map.add("embed", embed);
        } else if (data != null) {
            map.add("data", convertResourceToString(data));
        }

        if (caption != null) {
            map.add("caption", caption);
        }

        return map;
    }
}
