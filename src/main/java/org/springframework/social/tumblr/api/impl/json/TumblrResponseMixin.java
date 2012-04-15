package org.springframework.social.tumblr.api.impl.json;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.io.IOException;

@JsonDeserialize(using = TumblrResponseMixin.TumblrResponseDeserializer.class)
class TumblrResponseMixin {

    static class TumblrResponseDeserializer extends JsonDeserializer<TumblrResponse> {
        @Override
        public TumblrResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode root = jp.readValueAsTree();

            TumblrResponse response = new TumblrResponse();

            JsonNode meta = root.get("meta");

            response.setStatus(meta.get("status").getIntValue());
            response.setMessage(meta.get("msg").getTextValue());

            response.setResponseJson(root.get("response").toString());

            return response;
        }
    }

}
