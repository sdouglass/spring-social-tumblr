package org.springframework.social.tumblr.api.impl.json;

/**
 * @author sam
 * @version $Id$
 */

import org.codehaus.jackson.annotate.JsonProperty;

@SuppressWarnings("unused")
class BlogInfoMixin {

    @JsonProperty("ask_anon")
    private boolean askAnon;
}
