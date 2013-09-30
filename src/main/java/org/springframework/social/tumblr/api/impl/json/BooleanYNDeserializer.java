package org.springframework.social.tumblr.api.impl.json;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class BooleanYNDeserializer extends JsonDeserializer<Boolean> {

    private static final String YES = "Y";
    private static final String NO = "N";

    @Override
    public Boolean deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        try {
            return ctxt.getParser().getBooleanValue();
        } catch (JsonParseException jpe) {
            if (NO.equalsIgnoreCase(jp.getText())) {
                return false;
            } else if (YES.equalsIgnoreCase(jp.getText())) {
                return true;
            }
            throw jpe;
        }
    }

}
