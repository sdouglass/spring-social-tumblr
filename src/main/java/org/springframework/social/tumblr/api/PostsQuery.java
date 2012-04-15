package org.springframework.social.tumblr.api;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class PostsQuery {

    public static enum PostFormat {
        HTML(null),
        TEXT("text"),
        RAW("raw");

        private String formatString;

        private PostFormat(String formatString) {
            this.formatString = formatString;
        }

        public String getFormatString() {
            return formatString;
        }
    }

    private Long id;
    private PostType type;
    private String tag;
    private int offset = 0;
    private int limit = 20;
    private boolean returnReblogFields;
    private boolean returnNotesFields;
    private PostFormat format;

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
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

    public PostFormat getFormat() {
        return format;
    }

    public void setFormat(PostFormat format) {
        this.format = format;
    }

    public Long getSinceId() {
        return sinceId;
    }

    public void setSinceId(Long sinceId) {
        this.sinceId = sinceId;
    }

    public MultiValueMap<String, Object> toParameterMap() {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();

        if (id != null) {
            // if an id is specified only use that search criteria, as the user wants one specific post
            map.add("id", id.toString());
        } else {
            if (type != null) {
                map.add("type", type.getType());
            }
            if (tag != null) {
                map.add("tag", tag);
            }
            if (returnReblogFields) {
                map.add("reblog_info", "true");
            }
            if (returnNotesFields) {
                map.add("notes_info", "true");
            }
            if (format != null) {
                map.add("format", format.getFormatString());
            }
            map.add("offset", Integer.toString(offset));
            map.add("limit", Integer.toString(limit));

            if (sinceId != null) {
                map.add("since_id", sinceId);
            }
        }

        return map;
    }
}
