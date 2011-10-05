package org.bandhu.ext.test;

import java.io.FileInputStream;
import java.util.Properties;

import org.bandhu.core.rest.oauth.OAuthConsumer;
import org.bandhu.core.rest.oauth.OAuthToken;
import org.bandhu.ext.twitter.TwitterService;
import org.bandhu.ext.twitter.service.TwitterSP;
import org.bandhu.util.BandhuException;

import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.User;

import com.sun.jersey.oauth.signature.OAuthParameters;

public class TwitterTest extends BaseTest {
    static {
        properties = new Properties();
        try {
            configName = "jtwitter.properties";
            properties.load(new FileInputStream(configName));
            System.out.println("loaded..");
            System.out.println(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws BandhuException {
        TwitterService service = null;
        OAuthConsumer oAuthConsumer = new OAuthConsumer(
                "jAcw7UMqwgJhMetpJtKetA",
                "BQChxv9allmMJ482qzNhtae9RFyy4jytIgDmrkdT7jo");

        System.out.println("Use old session? (y/n)");

        String option = "y";
        // scanner.nextLine();
        if (Boolean.valueOf(option.equals("n"))) {
            TwitterSP oService = new TwitterSP(oAuthConsumer);
            verifyGetAccessToken(oService);
            service = new TwitterService(oService.getAccessToken());
        } else {
            System.out.println("Using old session...");
            OAuthToken accessToken = new OAuthToken(
                    properties.getProperty(OAuthParameters.TOKEN),
                    properties.getProperty(OAuthParameters.TOKEN_SECRET));
            service = new TwitterService(accessToken);
        }
        // getProfile(service);
        getHomeTweets(service, 1);
        // doRetweet(service);
        // replyToTweet(service);
        // deleteTweet(service);
        retweetsByMe(service);
    }

    private static void getProfile(TwitterService service)
            throws BandhuException {
        User user = service.verifyUser();
        System.out.println(user.getId() + " " + user.getScreenName() + "("
                + user.getName() + ")[" + user.getFollowersCount() + ","
                + user.getFriendsCount() + "]");
    }

    private static void getHomeTweets(TwitterService service, int pgId)
            throws BandhuException {
        Paging pg = new Paging(pgId);
        ResponseList<Status> stats = service.getHomeTimeline(pg);
        for (Status status : stats) {
            displayStatus(service, status);
        }
        System.out.println("Read more?");
        if (scanner.nextLine().equals("y")) {
            getHomeTweets(service, pg.getPage() + 1);
        }
    }

    private static void doRetweet(TwitterService service)
            throws BandhuException {
        System.out.println("Enter id to retweet:");
        Status retweet = service.retweet(scanner.nextLong());
        displayStatus(service, retweet);
    }

    private static void replyToTweet(TwitterService service)
            throws BandhuException {
        System.out.println("Enter id to reply:");
        long id = scanner.nextLong();
        System.out.println("Enter message..");
        String msg = scanner.nextLine();
        StatusUpdate stat = new StatusUpdate("@jasphior nice...");

        stat.setInReplyToStatusId(id);
        Status reply = service.updateStatus(stat);
        displayStatus(service, reply);
    }

    private static void deleteTweet(TwitterService service)
            throws BandhuException {
        System.out.println("Enter id to delete:");
        long id = scanner.nextLong();
        Status status = service.deleteStatus(id);
        displayStatus(service, status);
    }

    private static void retweetsByMe(TwitterService service)
            throws BandhuException {
        displayStatus(service, service.getRetweetedByMe());
    }

    private static void displayStatus(TwitterService service,
            ResponseList<Status> responseList) throws BandhuException {
        for (Status status : responseList) {
            displayStatus(service, status);
        }
    }

    private static void displayStatus(TwitterService service, Status status)
            throws BandhuException {
        System.out.println(status.getText());
        System.out.println("#" + status.getId() + "\t" + status.getCreatedAt());
        System.out.println("by "
                + status.getUser().getScreenName()
                + " via "
                + status.getSource()
                + (" in reply to " + status.getInReplyToStatusId() + "/"
                        + status.getInReplyToScreenName() + "/" + status
                            .getInReplyToUserId()));
        System.out.println("retweeted " + status.getRetweetCount() + " "
                + status.getSource());
        System.out.println("retweeted by me " + status.isRetweetedByMe() + " "
                + status.getRetweetedStatus());
        System.out.println("contribs " + status.getContributors() + "\r #tag "
                + status.getHashtagEntities() + " \r usr mentions"
                + status.getUserMentionEntities());
        if (status.getInReplyToStatusId() > -1) {
            System.out.println("\\//\\//\\// - Wooo conversation tree!!");
            Status con = service.getStatus(status.getInReplyToStatusId());
            displayStatus(service, con);
        }

        System.out
                .println("----------------------------------------------------------");

    }
}
