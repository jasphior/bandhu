package org.bandhu.ext.twitter;

import java.util.Scanner;

import org.bandhu.core.BandhuAdmin;
import org.bandhu.core.rest.oauth.OAuthService;
import org.bandhu.core.rest.oauth.OAuthToken;
import org.bandhu.ext.twitter.service.TwitterSP;
import org.bandhu.util.BandhuException;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class Test {

    public static void main(String[] args) throws BandhuException {
        // login();
        OAuthToken authToken = new OAuthToken(
                "276483722-NFyAoRpz7tsvOHLhUoI0SXqlGaa5ByMPUkRnqyDJ",
                "Q0rNhGDtsjNq1Wk0b1Q8LFlv7L6IXNSZcJBLXBOWw");
        TwitterService twitterService = new TwitterService(authToken);

        System.out.println(twitterService.getDirectMessages(new Paging(1)));
    }

    public static void mainx(String[] args) throws BandhuException,
            TwitterException {
        // login();

        OAuthToken authToken = new OAuthToken(
                "276483722-Jy60LXt3L7RdVYkmUc449YdIoHBp4A3mai8WiQsD",
                "tfvoS2CaNnYYVJTl9Po5Ja1EUNtZqdTyAwjtfYqDo");

        ConfigurationBuilder builder = new ConfigurationBuilder()
                .setOAuthConsumerKey(BandhuAdmin.TWITTER_KEY)
                .setOAuthConsumerSecret(BandhuAdmin.TWITTER_SECRET);
        Configuration configuration = builder.build();

        AccessToken accessToken = new AccessToken(
                "276483722-Jy60LXt3L7RdVYkmUc449YdIoHBp4A3mai8WiQsD",
                "tfvoS2CaNnYYVJTl9Po5Ja1EUNtZqdTyAwjtfYqDo");
        int i = 1;
        Paging paging = new Paging(i);
        do {
            paging.setPage(i);
            Twitter twitter = new TwitterFactory(configuration)
                    .getInstance(accessToken);
            ResponseList<Status> stats = twitter.getHomeTimeline(paging);
            for (Status status : stats) {
                System.out.println(status.getText());
                System.out.println(status.getUser());
            }
            i++;
        } while (!scanner.nextLine().equalsIgnoreCase("N"));

    }

    static Scanner scanner = new Scanner(System.in);

    private static void login() throws BandhuException {
        OAuthService authService = new OAuthService(BandhuAdmin.TWITTER,
                TwitterSP.class);

        String url = authService.getAuthenticationURL();
        System.out.println(url);
        authService.setVerifier(scanner.nextLine());
        OAuthToken accessTokenOauth = authService.fetchAccessToken();

        System.out.println(accessTokenOauth);
    }
}
