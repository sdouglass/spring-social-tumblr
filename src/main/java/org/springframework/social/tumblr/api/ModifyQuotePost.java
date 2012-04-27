package org.springframework.social.tumblr.api;

import org.springframework.util.MultiValueMap;

public class ModifyQuotePost extends ModifyPost {

    private String quote;
    private String source;

    public ModifyQuotePost() {
        super(PostType.QUOTE);
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public MultiValueMap<String, String> toParameterMap() {
        MultiValueMap<String, String> map = super.toParameterMap();

        map.add("quote", quote);

        if (source != null) {
            map.add("source", source);
        }

        return map;
    }
}
