package org.springframework.social.tumblr.api;

import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.MultiValueMap;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class ModifyPhotoPost extends ModifyPost {

    private String source;
    private List<Resource> data;
    private String caption;
    private String link;

    public ModifyPhotoPost() {
        super(PostType.PHOTO);
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<Resource> getData() {
        return data;
    }

    public void setData(List<Resource> data) {
        this.data = data;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public MultiValueMap<String, String> toParameterMap() {
        MultiValueMap<String, String> map = super.toParameterMap();

        if (source != null) {
            map.add("source", source);
        } else if (data != null) {
            for (int i = 0; i < data.size(); i++) {
                Resource resource = data.get(i);
                String bytesString = convertResourceToString(resource);
                map.add("data[" + i + "]", bytesString);
            }
        }

        if (caption != null) {
            map.add("caption", caption);
        }

        if (link != null) {
            map.add("link", link);
        }

        return map;
    }
}
