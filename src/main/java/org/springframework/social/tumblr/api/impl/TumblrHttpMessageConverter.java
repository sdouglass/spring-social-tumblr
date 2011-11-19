package org.springframework.social.tumblr.api.impl;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.tumblr.api.impl.json.TumblrModule;
import org.springframework.social.tumblr.api.impl.json.TumblrResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.io.EOFException;
import java.io.IOException;

/**
 * @author sam
 * @version $Id$
 */
public class TumblrHttpMessageConverter extends MappingJacksonHttpMessageConverter {

    private ObjectMapper objectMapper = new ObjectMapper();

    public TumblrHttpMessageConverter() {
        objectMapper.registerModule(new TumblrModule());
//        objectMapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        setObjectMapper(objectMapper);
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        try {
            TumblrResponse tumblrResponse = objectMapper.readValue(inputMessage.getBody(), TumblrResponse.class);
            checkResponse(tumblrResponse);
            Object result;
            if (clazz.equals(TumblrResponse.class)) {
                // don't parse the response json, callee is going to process is manually
                result = tumblrResponse;
            } else {
                // parse the response json into an instance of the given class
                result = objectMapper.readValue(tumblrResponse.getResponseJson(), clazz);
            }
            return result;
        }
        catch (JsonParseException ex) {
            throw new HttpMessageNotReadableException("Could not read JSON: " + ex.getMessage(), ex);
        }
        catch (EOFException ex) {
            throw new HttpMessageNotReadableException("Could not read JSON: " + ex.getMessage(), ex);
        }
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        super.writeInternal(o, outputMessage);
    }

    protected void checkResponse(TumblrResponse tumblrResponse) {
        HttpStatus httpStatus = HttpStatus.valueOf(tumblrResponse.getStatus());
        if (httpStatus.series() == HttpStatus.Series.CLIENT_ERROR) {
            throw new HttpClientErrorException(httpStatus, tumblrResponse.getMessage());
        } else if (httpStatus.series() == HttpStatus.Series.SERVER_ERROR) {
            throw new HttpServerErrorException(httpStatus, tumblrResponse.getMessage());
        }
    }
}
