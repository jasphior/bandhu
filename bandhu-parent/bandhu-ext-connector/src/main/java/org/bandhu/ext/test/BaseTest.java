package org.bandhu.ext.test;

import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Scanner;

import org.bandhu.core.rest.oauth.OAuthService;
import org.bandhu.core.rest.oauth.OAuthToken;
import org.bandhu.ext.ServiceID;
import org.bandhu.ext.util.ServiceParams;
import org.bandhu.util.BandhuConfig;
import org.bandhu.util.BandhuException;

import com.sun.jersey.oauth.signature.OAuthParameters;

public class BaseTest {
    protected static Properties properties;
    protected static String configName;
    protected static OAuthToken token;
    protected static Scanner scanner = new Scanner(System.in);

    static {
        BandhuConfig.setServiceResolver(ServiceID.CONFIG);
        BandhuConfig.setServiceParams(new ServiceParams());
    }

    protected static void verifyGetAccessToken(OAuthService service)
            throws BandhuException {
        String authenticationURL = service.getAuthenticationURL();
        System.out.println(authenticationURL);

        service.setVerifier(scanner.nextLine());
        token = service.fetchAccessToken();
        System.out.println(token);
        updateSession(token);
    }

    protected static void updateSession(OAuthToken token) {
        properties.setProperty(OAuthParameters.TOKEN, token.getToken());
        properties.setProperty(OAuthParameters.TOKEN_SECRET,
                token.getTokenSecret());
        try {
            properties.store(new FileOutputStream(configName), null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
