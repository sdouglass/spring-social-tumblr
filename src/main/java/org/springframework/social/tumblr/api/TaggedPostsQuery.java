package org.springframework.social.tumblr.api;

import org.springframework.util.MultiValueMap;

public class TaggedPostsQuery extends AbstractBasePostsQuery {

    private Long before;

    public Long getBefore() {
        return before;
    }

    public void setBefore(Long before) {
        this.before = before;
    }

    public MultiValueMap<String, String> toParameterMap() {
        MultiValueMap<String, String> map = super.toParameterMap();

        if (before != null) {
            map.add("before", before.toString());
        }

        return map;
    }
}
