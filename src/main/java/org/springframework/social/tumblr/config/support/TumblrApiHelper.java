package org.springframework.social.tumblr.config.support;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.tumblr.api.Tumblr;
import org.springframework.social.tumblr.api.impl.TumblrTemplate;

/**
 * Support class for JavaConfig and XML configuration support.
 * Creates an API binding instance for the current user's connection.
 */
public class TumblrApiHelper implements ApiHelper<Tumblr> {

    private final UsersConnectionRepository usersConnectionRepository;

    private final UserIdSource userIdSource;

    private TumblrApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
        this.usersConnectionRepository = usersConnectionRepository;
        this.userIdSource = userIdSource;        
    }

    public Tumblr getApi() {
        if (logger.isDebugEnabled()) {
            logger.debug("Getting API binding instance for Tumblr");
        }
        
        Connection<Tumblr> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(Tumblr.class);
        if (logger.isDebugEnabled() && connection == null) {
            logger.debug("No current connection; Returning default TumblrTemplate instance.");
        }
        return connection != null ? connection.getApi() : new TumblrTemplate();
    }

    private final static Log logger = LogFactory.getLog(TumblrApiHelper.class);

}