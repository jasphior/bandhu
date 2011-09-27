package org.bandhu.ext;

import org.bandhu.core.rest.oauth.OAuthService;
import org.bandhu.ext.twitter.TwitterService;
import org.bandhu.util.BandhuException;

import twitter4j.Status;
import twitter4j.StatusUpdate;

public class Twitter {

    private OAuthService oAuthService;
    private TwitterService twitterService;

    public Twitter(OAuthService oAuthService) throws BandhuException {
        this.oAuthService = oAuthService;
        twitterService = new TwitterService(oAuthService.getAccessToken());
    }

    public void tweet(String status) throws BandhuException {
        StatusUpdate statusUpdate = new StatusUpdate(status);
        Status updateStatus = twitterService.updateStatus(statusUpdate);
    }

    private void retweet() {
        // TODO Auto-generated method stub

    }

    private void deleteTweet() {
        // TODO Auto-generated method stub

    }

    private void sendDirectMessage() {
        // TODO Auto-generated method stub

    }

    private void respondDirectMessage() {
        // TODO Auto-generated method stub

    }

    private void deleteDirectMessage() {
        // TODO Auto-generated method stub

    }

    private void searchTweet() {
        // TODO Auto-generated method stub

    }

    private void searchPerson() {
        // TODO Auto-generated method stub

    }

    private void getMyTimeline() {
        // TODO Auto-generated method stub

    }

    private void getTimelineOf() {
        // TODO Auto-generated method stub

    }

    private void getPublicTimeline() {
        // TODO Auto-generated method stub

    }

    private void getTopTweets() {
        // TODO Auto-generated method stub

    }
}
