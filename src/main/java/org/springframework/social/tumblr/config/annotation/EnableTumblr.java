package org.springframework.social.tumblr.config.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Annotation to enable Tumbler in a Spring Social application.
 * Configures a {@link TumblrConnectionFactory} bean (and a {@link org.springframework.social.connect.ConnectionFactoryLocator} bean if one isn't already registered).
 * Also configures a request-scoped {@link org.springframework.social.tumblr.api.Tumblr} bean fetched from the current user's {@link org.springframework.social.connect.ConnectionRepository}.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(TumblrProviderConfigRegistrar.class)
public @interface EnableTumblr {

    String appId();

    String appSecret();

}
