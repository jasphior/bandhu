package org.bandhu.ext.twitter.bean;

import twitter4j.Friendship;
import twitter4j.User;

public class UserDetailed {
    private User user;
    private Friendship friendship;

    public UserDetailed(User user, Friendship friendship) {
        this.user = user;
        this.friendship = friendship;
    }

    public User getUser() {
        return user;
    }

    public Friendship getFriendship() {
        return friendship;
    }

}
