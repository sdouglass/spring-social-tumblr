package org.springframework.social.tumblr.api;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class PostsQuery extends AbstractBasePostsQuery {

    private Long id;
    private PostType type;
    private int offset = 0;
    private boolean returnReblogFields;
    private boolean returnNotesFields;

    // used for dashboard
    private Long sinceId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PostType getType() {
        return type;
    }

    public void setType(PostType type) {
        this.type = type;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public boolean isReturnReblogFields() {
        return returnReblogFields;
    }

    public void setReturnReblogFields(boolean returnReblogFields) {
        this.returnReblogFields = returnReblogFields;
    }

    public boolean isReturnNotesFields() {
        return returnNotesFields;
    }

    public void setReturnNotesFields(boolean returnNotesFields) {
        this.returnNotesFields = returnNotesFields;
    }

    public Long getSinceId() {
        return sinceId;
    }

    public void setSinceId(Long sinceId) {
        this.sinceId = sinceId;
    }

    public MultiValueMap<String, String> toParameterMap() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        if (id != null) {
            // if an id is specified only use that search criteria, as the user wants one specific post
            map.add("id", id.toString());
        } else {
            map = super.toParameterMap();
            if (type != null) {
                map.add("type", type.getType());
            }
            if (returnReblogFields) {
                map.add("reblog_info", "true");
            }
            if (returnNotesFields) {
                map.add("notes_info", "true");
            }
            map.add("offset", Integer.toString(offset));

            if (sinceId != null) {
                map.add("since_id", sinceId.toString());
            }
        }

        return map;
    }
}
