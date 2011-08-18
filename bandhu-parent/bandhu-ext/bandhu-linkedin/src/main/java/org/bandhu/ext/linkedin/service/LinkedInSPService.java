package org.bandhu.ext.linkedin.service;

import org.bandhu.core.rest.sp.RESTServiceProviderService;
import org.bandhu.ext.linkedin.jaxb.PersonType;
import org.bandhu.ext.linkedin.jaxb.UpdatesType;
import org.bandhu.ext.linkedin.util.LinkedInUtil;
import org.bandhu.util.BandhuUtil.Method;
import org.bandhu.util.BandhuUtil.Protocol;

public enum LinkedInSPService implements RESTServiceProviderService {

    /**
     * The Profile resource is the starting point for information about a
     * member. You can get the default view, or use Field Selectors to request
     * particular Profile Fields for a member. GET
     * http://api.linkedin.com/v1/people/~
     */
    PROFILE(Protocol.HTTP, Method.GET, "http://api.linkedin.com/v1/people/~:("
            + LinkedInUtil.PROFILE_FULL + ")", PersonType.class, true),
    /**
     * selected profile http://api.linkedin.com/v1/people/id=abcdefg
     */
    PROFILE_SELECT(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/people/id={0}:("
                    + LinkedInUtil.PROFILE_BASIC + ")", PersonType.class, true,
            1),

    /**
     * selected profile http://api.linkedin.com/v1/people/id=abcdefg
     */
    PROFILE_SELECT_CONNECTED(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/people/id={0}:("
                    + LinkedInUtil.PROFILE_FULL + ")", PersonType.class, true,
            1),
    /**
     * profile @ public url
     * http://api.linkedin.com/v1/people/url=<public_profile_url>
     */
    PROFILE_PUBLIC(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/people/url={0}:("
                    + LinkedInUtil.PROFILE + ")", String.class, true, 1),

    /**
     * The People Search resource searches for people matching your search
     * criteria.
     * 
     * GET http://api.linkedin.com/v1/people-search? keywords=[space delimited
     * keywords]& first-name=[first name]& last-name=[last name]&
     * company-name=[company name]& current-company=[true|false]& title=[title]&
     * current-title=[true|false]& school-name=[school name]&
     * current-school=[true|false]& country-code=[country code]&
     * postal-code=[postal code]& distance=[miles]& start=[number]&
     * count=[1-25]& facet=[facet code, values]& facets=[facet codes]&
     * sort=[connections|recommenders|distance|relevance]
     */
    SEARCH(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/people-search:(people:("
                    + LinkedInUtil.PROFILE + "))?{0}", String.class, true, 1),
    /**
     * The Connections resource allows you to see information about the member's
     * network.
     * 
     * GET http://api.linkedin.com/v1/people/~/connections http://api.linkedin
     * .com/v1/people/url=http%3A%2F%2Fwww.linkedin.com%2Fin%2F
     * lbeebe/connections
     */
    CONNECTIONS(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/people/~/connections", String.class,
            true),
    /**
     * Selected connection
     * http://api.linkedin.com/v1/people/id=12345/connections
     */
    CONNECTIONS_SELECT(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/people/id={0}/connections",
            String.class, true, 1),

    /**
     * The Companies resource allows you to see information about companies.
     */
    COMPANY_SELECT(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/companies/{0}", String.class, true, 1),

    /**
     * The Company Search API enables search across company pages.
     */
    COMPANY_SEARCH(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/company-search:(companies:("
                    + LinkedInUtil.COMPANY + "))?keywords={0}", String.class,
            true, 1),

    /**
     * Retrieve a list of companies a member is following
     */
    COMPANY_FOLLOWED(Protocol.HTTP, Method.GET,
            " http://api.linkedin.com/v1/people/~/following/companies:("
                    + LinkedInUtil.COMPANY + ")", String.class, true),

    /**
     * The Company Search API enables search across company pages.
     */
    COMPANY_FOLLOW(Protocol.HTTP, Method.POST,
            "http://api.linkedin.com/v1/people/~/following/companies",
            String.class, true),

    /**
     * Stop Following a Company
     */
    COMPANY_UNFOLLOW(Protocol.HTTP, Method.DELETE,
            "http://api.linkedin.com/v1/people/~/following/companies/id={id}",
            String.class, true, 1),

    /**
     * Suggested Companies to Follow
     * 
     * You can retrieve a collection of suggested companies for the current
     * user.
     */
    COMPANY_SUGGESTION(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/people/~/suggestions/to-follow/companies:("
                    + LinkedInUtil.COMPANY + ")", String.class, true),
    /**
     * Return a list of products and services supported by a company & Return
     * recommendations for a particular product
     */
    COMPANY_PRODUCTS(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/companies/{0}/products:("
                    + LinkedInUtil.PRODUCT + ")", String.class, true),

    /**
     * The Jobs API returns detailed information about job postings on LinkedIn.
     * Find the job summary, description, location, and apply our professional
     * graph to present the relationship between the current member and the job
     * poster or hiring manager. Use inline filters and LinkedIn's unique nested
     * domain structure to explore details about the job and the hiring company
     * within a single REST call.
     */
    JOB_SELECT(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/jobs/{0}:(" + LinkedInUtil.JOB + ")",
            String.class, true, 1),

    /**
     * The Jobs API returns detailed information about job postings on LinkedIn.
     * Find the job summary, description, location, and apply our professional
     * graph to present the relationship between the current member and the job
     * poster or hiring manager. Use inline filters and LinkedIn's unique nested
     * domain structure to explore details about the job and the hiring company
     * within a single REST call.
     */
    JOB_SEARCH(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/job-search:(jobs:(" + LinkedInUtil.JOB
                    + "))?{0}", String.class, true, 1),

    /**
     * Jobs can be saved (bookmarked) for later use by a member. If a member
     * applies to a job through LinkedIn, the application date is saved with the
     * job bookmark. The API can be used to retrieve the current members job
     * bookmarks and add new bookmarks to that member's account. Suggested jobs
     * for a member can also be retrieved, in order to present a member with
     * customized and relevant job opportunities.
     * 
     * Retrieving Job Bookmarks
     * 
     * Use the Job Bookmark API to retrieve a list of bookmarked jobs for a
     * member
     */
    JOB_BOOKMARKED(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/people/~/job-bookmarks", String.class,
            true),

    /**
     * To bookmark a job to the current user's account, post the following data:
     * 
     * <?xml version="1.0" encoding="UTF-8" standalone="yes"?> <job-bookmark>
     * <job> <id>{job-id}</id> </job> </job-bookmark>
     */
    JOB_BOOKMARK(Protocol.HTTP, Method.POST,
            "http://api.linkedin.com/v1/people/~/job-bookmarks", String.class,
            true),

    /**
     * To delete a bookmarked job from the current user's account, use the
     * following call:
     */
    JOB_BOOKMARK_DELETE(Protocol.HTTP, Method.DELETE,
            "http://api.linkedin.com/v1/people/~/job-bookmarks/{0}",
            String.class, true, 1),

    /**
     * To delete a bookmarked job from the current user's account, use the
     * following call:
     */
    JOB_SUGGESTION(
            Protocol.HTTP,
            Method.GET,
            "http://api.linkedin.com/v1/people/~/suggestions/job-suggestions:(jobs)",
            String.class, true, 1),

    /**
     * Messaging
     * 
     * Allows the member to send Messages to their connections, or send
     * Invitations to connect.
     * 
     * POST http://api.linkedin.com/v1/people/~/mailbox
     */
    MESSAGING(Protocol.HTTP, Method.POST,
            "http://api.linkedin.com/v1/people/~/mailbox", String.class, true),

    // Network Updates
    /**
     * Getting updates
     * 
     * Use the Network Updates resource to retrieve network updates for the
     * member or their connections.
     * 
     * To retrieve the member's updates:
     * 
     * GET http://api.linkedin.com/v1/people/~/network/updates
     */
    UPDATES(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/people/~/network/updates",
            UpdatesType.class, true),

    /**
     * http://api.linkedin.com/v1/people/~/network/updates?scope=self
     */
    UPDATES_FILTER(Protocol.HTTP, Method.GET,
            "http://api.linkedin.com/v1/people/~/network/updates?{0}",
            String.class, true, 1),

    /**
     * http://api.linkedin.com/v1/people/id=abcdefg/network/updates?scope=self
     * 
     */
    UPDATES_SELCTED_SELF(
            Protocol.HTTP,
            Method.GET,
            "http://api.linkedin.com/v1/people/id={0}/network/updates?scope=self",
            String.class, true, 1),

    /**
     * Posting Updates
     * 
     * There is a separate resource for posting Network Updates for the member.
     * 
     * POST http://api.linkedin.com/v1/people/~/person-activities
     */
    POSTING_UPDATES(Protocol.HTTP, Method.POST,
            "http://api.linkedin.com/v1/people/~/person-activities",
            String.class, true),

    /**
     * Posting Shares
     * 
     * You can use the Share resource to post shares on behalf of the member.
     * 
     * POST http://api.linkedin.com/v1/people/~/shares
     */
    POSTING_SHARES(Protocol.HTTP, Method.POST,
            "http://api.linkedin.com/v1/people/~/shares", String.class, true),

    /**
     * Comments and Likes
     * 
     * There are various resources available for accessing comments and likes
     * for network updates.
     * 
     * By default, a network update containing more than 10 comments will only
     * return you the most recent five. To retrieve all comments for a given
     * network update:
     * 
     * 
     * Where {NETWORK UPDATE KEY} is a update/update-key representing an update.
     * Returns all comments belonging to this network update, following the same
     * structure as above.
     * 
     * 
     * 
     * Use a similar syntax to retrive the complete list of people who liked an
     * update:
     * 
     * GET http://api.linkedin.com/v1/people/~/network/updates/key={NETWORK
     * UPDATE KEY}/update-comments
     */
    COMMENTS_UPDATE(
            Protocol.HTTP,
            Method.GET,
            "http://api.linkedin.com/v1/people/~/network/updates/key={0}/update-comments",
            String.class, true, 1),

    /**
     * Post a comment to an existing update: POST
     * http://api.linkedin.com/v1/people/~/network/updates/key={NETWORK UPDATE
     * KEY}/update-comments Like an existing update:
     */
    POSTING_COMMENT(
            Protocol.HTTP,
            Method.POST,
            "http://api.linkedin.com/v1/people/~/network/updates/key={0}/update-comments",
            String.class, true, 1),

    /**
     * Post a message
     */
    POSTING_MESSAGE(Protocol.HTTP, Method.POST,
            "http://api.linkedin.com/v1/people/~/mailbox", String.class, true,
            1),

    /**
     * Post an invite
     */
    POSTING_INVITE(Protocol.HTTP, Method.POST,
            "http://api.linkedin.com/v1/people/~/mailbox", String.class, true,
            1),

    /**
     * GET http://api.linkedin.com/v1/people/~/network/updates/key={NETWORK
     * UPDATE KEY}/likes
     */
    LIKES(
            Protocol.HTTP,
            Method.GET,
            "http://api.linkedin.com/v1/people/~/network/updates/key={0}/likes",
            String.class, true, 1),

    /**
     * PUT http://api.linkedin.com/v1/people/~/network/updates/key={NETWORK
     * UPDATE KEY}/is-liked
     */
    POSTING_LIKES(
            Protocol.HTTP,
            Method.PUT,
            "http://api.linkedin.com/v1/people/~/network/updates/key={0}/is-liked",
            String.class, true, 1);

    private Protocol protocol;
    private Method method;
    private String url;
    private Class<?> entity;
    private int urlParams;
    private boolean authenticationRequired;

    LinkedInSPService(final Protocol protocol, final Method method,
            final String url, final Class<?> entity,
            boolean authenticationRequired) {
        this.protocol = protocol;
        this.method = method;
        this.url = url;
        this.entity = entity;
        this.authenticationRequired = authenticationRequired;
    }

    LinkedInSPService(final Protocol protocol, final Method method,
            final String url, final Class<?> entity,
            boolean authenticationRequired, int urlParams) {
        this.protocol = protocol;
        this.method = method;
        this.url = url;
        this.entity = entity;
        this.urlParams = urlParams;
        this.authenticationRequired = authenticationRequired;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public Method getMethod() {
        return method;
    }

    public String getURL() {
        return url;
    }

    public Class<?> getEntity() {
        return entity;
    }

    public int getURLParamCount() {
        return urlParams;
    }

    public boolean isAuthenticationRequired() {
        return authenticationRequired;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("LinkedInServices [protocol=").append(protocol)
                .append(", method=").append(method).append(", url=")
                .append(url).append(", clazz=").append(entity).append("]");
        return builder.toString();
    }
}
