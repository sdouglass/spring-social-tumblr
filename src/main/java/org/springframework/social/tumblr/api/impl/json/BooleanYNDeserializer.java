package org.springframework.social.tumblr.api.impl.json;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

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
