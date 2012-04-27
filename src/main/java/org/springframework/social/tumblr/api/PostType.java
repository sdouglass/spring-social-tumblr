package org.springframework.social.tumblr.api;

public enum PostType {
    TEXT("text"),
    PHOTO("photo"),
    QUOTE("quote"),
    LINK("link"),
    CHAT("chat"),
    AUDIO("audio"),
    VIDEO("video"),
    ANSWER("answer"), // docs only mention this for reading, not for posting/editing???
    REBLOG("reblog"); // not sure if this last one is really necessary

    private String type;

    PostType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }

    public static PostType getByType(String type) {
        PostType result = null;
        for (PostType postType : values()) {
            if (postType.getType().equals(type)) {
                result = postType;
                break;
            }
        }
        return result;
    }
}
