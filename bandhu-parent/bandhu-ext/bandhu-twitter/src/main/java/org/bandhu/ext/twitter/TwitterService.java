package org.bandhu.ext.twitter;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.bandhu.core.BandhuAdmin;
import org.bandhu.core.rest.oauth.OAuthToken;
import org.bandhu.ext.twitter.bean.IDsList;
import org.bandhu.ext.twitter.bean.UserDetailed;
import org.bandhu.util.BandhuException;

import twitter4j.Category;
import twitter4j.DirectMessage;
import twitter4j.Friendship;
import twitter4j.GeoQuery;
import twitter4j.IDs;
import twitter4j.Paging;
import twitter4j.Place;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.ResponseList;
import twitter4j.SavedSearch;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.auth.AccessToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterService {
    private Twitter twitter;

    public TwitterService(OAuthToken oAuthToken) {
        ConfigurationBuilder builder = new ConfigurationBuilder()
                .setOAuthConsumerKey(BandhuAdmin.TWITTER_KEY)
                .setOAuthConsumerSecret(BandhuAdmin.TWITTER_SECRET);
        Configuration configuration = builder.build();
        AccessToken accessToken = new AccessToken(oAuthToken.getToken(),
                oAuthToken.getTokenSecret());

        twitter = new TwitterFactory(configuration).getInstance(accessToken);
    }

    public User verifyUser() throws BandhuException {
        try {
            User user = twitter.verifyCredentials();
            return user;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public DirectMessage getSendDirectMessage(long id, String text)
            throws BandhuException {
        try {
            DirectMessage msg = twitter.sendDirectMessage(id, text);
            return msg;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<DirectMessage> getDirectMessages()
            throws BandhuException {
        return getDirectMessages(null);
    }

    public ResponseList<DirectMessage> getDirectMessages(Paging paging)
            throws BandhuException {
        try {
            ResponseList<DirectMessage> directMessages = null;
            if (paging == null) {
                directMessages = twitter.getDirectMessages();
            } else {
                directMessages = twitter.getDirectMessages(paging);
            }
            return directMessages;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<DirectMessage> getSentDirectMessages()
            throws BandhuException {
        return getSentDirectMessages(null);
    }

    public ResponseList<DirectMessage> getSentDirectMessages(Paging paging)
            throws BandhuException {
        try {
            ResponseList<DirectMessage> directMessages = null;
            if (paging == null) {
                directMessages = twitter.getSentDirectMessages();
            } else {
                directMessages = twitter.getSentDirectMessages(paging);
            }
            return directMessages;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public DirectMessage deleteDirectMessages(long id) throws BandhuException {
        try {
            DirectMessage directMessage = twitter.destroyDirectMessage(id);
            return directMessage;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public DirectMessage getDirectMessage(long id) throws BandhuException {
        try {
            DirectMessage directMessage = twitter.showDirectMessage(id);
            return directMessage;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public Status tweet(String statusUpdate) throws BandhuException {
        try {
            Status status = twitter.updateStatus(statusUpdate);
            return status;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public Status updateStatus(StatusUpdate statusUpdate)
            throws BandhuException {
        try {
            Status status = twitter.updateStatus(statusUpdate);
            return status;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public Status reply(String messageTxt, long id) throws BandhuException {
        try {
            StatusUpdate stat = new StatusUpdate(messageTxt);
            stat.setInReplyToStatusId(id);
            Status status = twitter.updateStatus(stat);
            return status;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }

    }

    public Status deleteStatus(long id) throws BandhuException {
        try {
            Status status = twitter.destroyStatus(id);
            return status;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public Status retweet(long id) throws BandhuException {
        try {
            Status status = twitter.retweetStatus(id);
            return status;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<Status> getRetweetedByMe() throws BandhuException {
        return getRetweetedByMe(null);
    }

    public ResponseList<Status> getRetweetedByMe(Paging paging)
            throws BandhuException {
        try {
            ResponseList<Status> userTimeline = null;
            if (paging == null) {
                userTimeline = twitter.getRetweetedByMe();
            } else {
                userTimeline = twitter.getRetweetedByMe(paging);
            }
            return userTimeline;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<Status> getRetweetedByUser(long id, Paging paging)
            throws BandhuException {
        try {
            ResponseList<Status> userTimeline = twitter.getRetweetedByUser(id,
                    paging);
            return userTimeline;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public boolean deleteRetweetOf(long id) throws BandhuException {
        try {
            Paging paging = new Paging(1);
            paging.setCount(50);
            boolean deleted = false;
            while (!deleted) {
                ResponseList<Status> retweets = getRetweetedByMe(paging);
                for (Status status : retweets) {
                    if (status.getRetweetedStatus().getId() == id) {
                        deleteStatus(status.getId());
                        deleted = true;
                        return true;
                    }
                }
                if (retweets.size() < paging.getCount()) {
                    return true;
                } else {
                    paging.setPage(paging.getPage() + 1);
                }
            }
            return false;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public Status getStatus(long id) throws BandhuException {
        try {
            Status status = twitter.showStatus(id);
            return status;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public User getUser(long id) throws BandhuException {
        try {
            User user = twitter.showUser(id);
            return user;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public User getUser(String screenName) throws BandhuException {
        try {
            User user = twitter.showUser(screenName);
            return user;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<Status> getUserTimeline() throws BandhuException {
        return getUserTimeline(null);
    }

    public ResponseList<Status> getUserTimeline(Paging paging)
            throws BandhuException {
        try {
            ResponseList<Status> userTimeline = null;
            if (paging == null) {
                userTimeline = twitter.getUserTimeline();
            } else {
                userTimeline = twitter.getUserTimeline(paging);
            }
            return userTimeline;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<Status> getHomeTimeline() throws BandhuException {
        return getHomeTimeline(null);
    }

    public ResponseList<Status> getHomeTimeline(Paging paging)
            throws BandhuException {
        try {
            ResponseList<Status> userTimeline = null;
            if (paging == null) {
                userTimeline = twitter.getHomeTimeline();
            } else {
                userTimeline = twitter.getHomeTimeline(paging);
            }
            return userTimeline;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<Status> getPublicTimeline() throws BandhuException {
        try {
            ResponseList<Status> userTimeline = twitter.getPublicTimeline();
            return userTimeline;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<Status> getMentions() throws BandhuException {
        return getMentions(null);
    }

    public ResponseList<Status> getMentions(Paging paging)
            throws BandhuException {
        try {
            ResponseList<Status> userTimeline = null;
            if (paging == null) {
                userTimeline = twitter.getMentions();
            } else {
                userTimeline = twitter.getMentions(paging);
            }
            return userTimeline;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public User follow(long id, boolean notify) throws BandhuException {
        try {
            User user = twitter.createFriendship(id, notify);
            return user;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public User follow(String screenName, boolean notify)
            throws BandhuException {
        try {
            User user = twitter.createFriendship(screenName, notify);
            return user;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public User unfollow(long id) throws BandhuException {
        try {
            User user = twitter.destroyFriendship(id);
            return user;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public User unfollow(String screenName) throws BandhuException {
        try {
            User user = twitter.destroyFriendship(screenName);
            return user;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<User> searchUsers(String query, int pageNumber)
            throws BandhuException {
        try {
            ResponseList<User> users = twitter.searchUsers(query, pageNumber);
            return users;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<Place> searchPlaces(GeoQuery query)
            throws BandhuException {
        try {
            ResponseList<Place> places = twitter.searchPlaces(query);
            return places;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public QueryResult search(Query query) throws BandhuException {
        try {
            QueryResult result = twitter.search(query);
            return result;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public Status favourite(long id) throws BandhuException {
        try {
            Status status = twitter.createFavorite(id);
            return status;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public Status removeFavourite(long id) throws BandhuException {
        try {
            Status status = twitter.destroyFavorite(id);
            return status;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public User updateProfileImage(InputStream image) throws BandhuException {
        try {
            User user = twitter.updateProfileImage(image);
            return user;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public User updateProfileBackgroundImage(InputStream image, boolean tile)
            throws BandhuException {
        try {
            User user = twitter.updateProfileBackgroundImage(image, tile);
            return user;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<Category> getSuggestedUserCategories()
            throws BandhuException {
        try {
            ResponseList<Category> categories = twitter
                    .getSuggestedUserCategories();
            return categories;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<User> suggestedUsers(String key) throws BandhuException {
        try {
            ResponseList<User> categories = twitter.getUserSuggestions(key);
            return categories;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public IDsList<UserDetailed> getFriendsIDs(long userId, long cursor)
            throws BandhuException {
        try {
            IDs ids = twitter.getFriendsIDs(userId, cursor);
            return getUsersDetailed(ids);
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public IDsList<UserDetailed> getFollowersIDs(long userId, long cursor)
            throws BandhuException {
        try {
            IDs ids = twitter.getFollowersIDs(userId, cursor);
            return getUsersDetailed(ids);
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<Friendship> getFriendships(long[] ids)
            throws BandhuException {
        try {
            ResponseList<Friendship> friendships = twitter
                    .lookupFriendships(ids);
            return friendships;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<User> getUsers(long[] ids) throws BandhuException {
        try {
            ResponseList<User> users = twitter.lookupUsers(ids);
            return users;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<User> getInFriends(long cursor) throws BandhuException {
        try {
            IDs ids = twitter.getIncomingFriendships(cursor);
            ResponseList<User> users = getUsers(ids.getIDs());
            return users;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<User> getOutFriends(long cursor) throws BandhuException {
        try {
            IDs ids = twitter.getOutgoingFriendships(cursor);
            ResponseList<User> users = getUsers(ids.getIDs());
            return users;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public IDsList<UserDetailed> getUsersDetailed(IDs ids)
            throws BandhuException {
        try {
            ResponseList<User> users = getUsers(ids.getIDs());
            ResponseList<Friendship> friendships = getFriendships(ids.getIDs());

            Map<Long, Friendship> mapFS = new HashMap<Long, Friendship>();

            for (Friendship friendship : friendships) {
                mapFS.put(friendship.getId(), friendship);
            }

            Map<Long, User> mapUsr = new HashMap<Long, User>();

            for (User user : users) {
                mapUsr.put(user.getId(), user);
            }

            IDsList<UserDetailed> list = new IDsList<UserDetailed>(ids);

            for (Long id : list.getIDs().getIDs()) {
                list.add(id, new UserDetailed(mapUsr.get(id), mapFS.get(id)));
            }

            return list;
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public void unBlock(long id) throws BandhuException {
        try {
            twitter.destroyBlock(id);
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public void unBlock(String screenName) throws BandhuException {
        try {
            twitter.destroyBlock(screenName);
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public void block(long id) throws BandhuException {
        try {
            twitter.createBlock(id);
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public void block(String screenName) throws BandhuException {
        try {
            twitter.createBlock(screenName);
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public UserList createList(String name, boolean isPublic, String desc)
            throws BandhuException {
        try {
            return twitter.createUserList(name, isPublic, desc);
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public UserList deleteList(int listId) throws BandhuException {
        try {
            return twitter.destroyUserList(listId);
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public UserList createUserListSubscription(int listId)
            throws BandhuException {
        try {
            return twitter.createUserListSubscription(listId);
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public UserList deleteListSubscription(int listId) throws BandhuException {
        try {
            return twitter.destroyUserListSubscription(listId);
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public SavedSearch saveSearch(String query) throws BandhuException {
        try {
            return twitter.createSavedSearch(query);
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public ResponseList<SavedSearch> getSavedSearches() throws BandhuException {
        try {
            return twitter.getSavedSearches();
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public SavedSearch getSavedSearch(int searchId) throws BandhuException {
        try {
            return twitter.showSavedSearch(searchId);
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

    public SavedSearch deleteSearch(int listId) throws BandhuException {
        try {
            return twitter.destroySavedSearch(listId);
        } catch (Exception e) {
            throw new BandhuException(e.getMessage());
        }
    }

}
