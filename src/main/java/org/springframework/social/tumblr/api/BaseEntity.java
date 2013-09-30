package org.springframework.social.tumblr.api;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

/**
 * Tumblr occasionally adds new undocumented fields to their API responses.
 *
 * Set up a map and method for collecting the values for these new fields
 * to avoid deserialization errors but still make the new values available.
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
