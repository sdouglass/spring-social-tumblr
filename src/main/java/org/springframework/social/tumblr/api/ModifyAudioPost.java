package org.springframework.social.tumblr.api;

import org.springframework.core.io.Resource;
import org.springframework.util.MultiValueMap;

public class ModifyAudioPost extends ModifyPost {

    private String externalUrl;
    private Resource data;
    private String caption;

    public ModifyAudioPost() {
        super(PostType.AUDIO);
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
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

        if (externalUrl != null) {
            map.add("external_url", externalUrl);
        } else if (data != null) {
            map.add("data", convertResourceToString(data));
        }

        if (caption != null) {
            map.add("caption", caption);
        }

        return map;
    }

    @Override
    public String toString() {
        return "ModifyAudioPost{" +
                "externalUrl='" + externalUrl + '\'' +
                ", caption='" + caption + '\'' +
                "} " + super.toString();
    }
}
