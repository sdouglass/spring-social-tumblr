package org.springframework.social.tumblr.config.annotation;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.social.config.annotation.AbstractProviderConfigRegistrarSupport;
import org.springframework.social.security.provider.SocialAuthenticationService;
import org.springframework.social.tumblr.config.support.TumblrApiHelper;
import org.springframework.social.tumblr.connect.TumblrConnectionFactory;
import org.springframework.social.tumblr.security.TumblrAuthenticationService;

import java.util.Map;

/**
 * {@link org.springframework.context.annotation.ImportBeanDefinitionRegistrar} for configuring a {@link TumblrConnectionFactory} bean and a request-scoped {@link org.springframework.social.tumblr.api.Tumblr} bean.
 */
public class TumblrProviderConfigRegistrar extends AbstractProviderConfigRegistrarSupport {

    public TumblrProviderConfigRegistrar() {
        super(EnableTumblr.class, TumblrConnectionFactory.class, TumblrApiHelper.class);
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
