package org.springframework.social.tumblr.api.impl.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;

@JsonDeserialize(using = TumblrResponseMixin.TumblrResponseDeserializer.class)
class TumblrResponseMixin {

    static class TumblrResponseDeserializer extends JsonDeserializer<TumblrResponse> {
        @Override
        public TumblrResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode root = jp.readValueAsTree();

            TumblrResponse response = new TumblrResponse();

            JsonNode meta = root.get("meta");

            response.setStatus(meta.get("status").intValue());
            response.setMessage(meta.get("msg").textValue());

            response.setResponseJson(root.get("response").toString());

            return response;
        }
    }

}
