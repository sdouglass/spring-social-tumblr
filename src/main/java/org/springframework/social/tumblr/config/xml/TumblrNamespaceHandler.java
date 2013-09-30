package org.springframework.social.tumblr.config.xml;

import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.config.xml.AbstractProviderConfigNamespaceHandler;

/**
 * {@link org.springframework.beans.factory.xml.NamespaceHandler} for Spring Social Facebook
 */
public class TumblrNamespaceHandler extends AbstractProviderConfigNamespaceHandler {

    @Override
    protected AbstractProviderConfigBeanDefinitionParser getProviderConfigBeanDefinitionParser() {
        return new TumblrConfigBeanDefinitionParser();
    }

}
