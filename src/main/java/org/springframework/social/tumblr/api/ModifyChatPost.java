package org.springframework.social.tumblr.api;

import org.springframework.util.MultiValueMap;

public class ModifyChatPost extends ModifyPost {

    /**
     * The text of the conversation/chat, with dialogue labels (no HTML).
     */
    private String conversation;
    private String title;

    public ModifyChatPost() {
        super(PostType.CHAT);
    }

    public String getConversation() {
        return conversation;
    }

    public void setConversation(String conversation) {
        this.conversation = conversation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public MultiValueMap<String, String> toParameterMap() {
        MultiValueMap<String, String> map = super.toParameterMap();

        map.add("conversation", conversation);

        if (title != null) {
            map.add("title", title);
        }

        return map;
    }
}
