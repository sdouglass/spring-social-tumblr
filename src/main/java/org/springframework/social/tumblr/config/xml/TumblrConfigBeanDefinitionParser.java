package org.springframework.social.tumblr.config.xml;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.social.config.xml.AbstractProviderConfigBeanDefinitionParser;
import org.springframework.social.security.provider.SocialAuthenticationService;
import org.springframework.social.tumblr.config.support.TumblrApiHelper;
import org.springframework.social.tumblr.connect.TumblrConnectionFactory;
import org.springframework.social.tumblr.security.TumblrAuthenticationService;

import java.util.Map;

/**
 * Implementation of {@link AbstractProviderConfigBeanDefinitionParser} that creates a {@link TumblrConnectionFactory}.
 */
public class TumblrConfigBeanDefinitionParser extends AbstractProviderConfigBeanDefinitionParser {
    public TumblrConfigBeanDefinitionParser() {
        super(TumblrConnectionFactory.class, TumblrApiHelper.class);
    }

    @Override
    protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
        return TumblrAuthenticationService.class;
    }

    @Override
    protected BeanDefinition getConnectionFactoryBeanDefinition(String appId, String appSecret, Map<String, Object> allAttributes) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(TumblrConnectionFactory.class).addConstructorArgValue(appId).addConstructorArgValue(appSecret);
        return builder.getBeanDefinition();
    }
}
