package org.springframework.social.tumblr.api;

import org.codehaus.jackson.annotate.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Tumblr adds new fields to their response. Set up a map 
 * and method for collecting the values for these new fields
 * to avoid deserialization errors and still make the new
 * values available.
 */
public class BaseEntity {
    
    private Map<String, Object> properties = new HashMap<String, Object>();
    
    @JsonAnySetter
    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }
    
    public Map<String, Object> getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "properties=" + properties +
                '}';
    }
}
