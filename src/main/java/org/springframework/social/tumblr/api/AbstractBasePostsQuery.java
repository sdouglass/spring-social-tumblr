package org.springframework.social.tumblr.api;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public abstract class AbstractBasePostsQuery {

    private String tag;
    private int limit = 20;
    private PostsQueryFilter filter;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public PostsQueryFilter getFilter() {
        return filter;
    }

    public void setFilter(PostsQueryFilter filter) {
        this.filter = filter;
    }


    public MultiValueMap<String, String> toParameterMap() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        if (tag != null) {
            map.add("tag", tag);
        }
        if (filter != null) {
            map.add("filter", filter.getValue());
        }
        map.add("limit", Integer.toString(limit));

        return map;
    }
}
