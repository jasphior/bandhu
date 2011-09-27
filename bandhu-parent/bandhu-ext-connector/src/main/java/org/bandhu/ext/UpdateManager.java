package org.bandhu.ext;

import org.bandhu.core.ServiceAccessor;
import org.bandhu.ext.linkedin.LinkedInService;
import org.bandhu.ext.linkedin.jaxb.PersonType;
import org.bandhu.ext.linkedin.service.LinkedInSP;
import org.bandhu.ext.model.Profile;
import org.bandhu.ext.twitter.TwitterService;
import org.bandhu.ext.twitter.service.TwitterSP;
import org.bandhu.ext.util.BeanConverter;
import org.bandhu.util.BandhuException;

import twitter4j.User;

public class UpdateManager {
    public Profile getInitialProfile(ServiceAccessor accessor)
            throws BandhuException {
        Profile profile = new Profile();

        if (accessor instanceof LinkedInSP) {
            LinkedInSP sp = (LinkedInSP) accessor;
            LinkedInService service = new LinkedInService(sp);
            PersonType person = service.getProfile();
            BeanConverter.convert(person, profile);
        } else if (accessor instanceof TwitterSP) {
            TwitterSP sp = (TwitterSP) accessor;
            TwitterService service = new TwitterService(sp.getAccessToken());
            User user = service.verifyUser();
            BeanConverter.convert(user, profile);
        } else if (accessor.isExternal()) {

        }

        return profile;
    }

}
