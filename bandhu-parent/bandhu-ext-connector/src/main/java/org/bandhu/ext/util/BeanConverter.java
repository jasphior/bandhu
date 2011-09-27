package org.bandhu.ext.util;

import org.bandhu.ext.linkedin.jaxb.PersonType;
import org.bandhu.ext.model.Profile;

import twitter4j.User;

public class BeanConverter {

    public static void convert(PersonType from, Profile to) {
        to.setId(from.getId());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setDisplayName(from.getFirstName() + " " + from.getLastName());
        to.setPictureUrl(from.getPictureUrl());
    }

    public static void convert(User from, Profile to) {
        to.setId(String.valueOf(from.getId()));
        to.setDisplayName(from.getName());
        to.setPictureUrl(from.getProfileImageURL().getPath());
        to.addParam(ParamConstants.TWI_FOLLOWERS, from.getFollowersCount());
        to.addParam(ParamConstants.TWI_FOLLOWING, from.getFriendsCount());
        to.addParam(ParamConstants.TWI_FOLLOWING, from.getFavouritesCount());
    }
}
