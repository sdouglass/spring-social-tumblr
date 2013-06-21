package org.springframework.social.tumblr.api;

/**
 * Specifies the post format to return, other than HTML:
 * text – Plain text, no HTML
 * raw – As entered by the user (no post-processing); if the user writes
 *       in Markdown, the Markdown will be returned rather than HTML
 *
 * (null/no value = HTML)
 */
public enum PostsQueryFilter {
    HTML(null),
    TEXT("text"),
    RAW("raw");

    private String value;

    PostsQueryFilter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
