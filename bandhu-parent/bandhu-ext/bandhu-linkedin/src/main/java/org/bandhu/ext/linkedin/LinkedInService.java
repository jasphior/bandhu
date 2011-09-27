package org.bandhu.ext.linkedin;

import org.bandhu.core.rest.oauth.OAuthRequest;
import org.bandhu.core.rest.oauth.OAuthService;
import org.bandhu.ext.linkedin.jaxb.CompaniesType;
import org.bandhu.ext.linkedin.jaxb.CompanyType;
import org.bandhu.ext.linkedin.jaxb.ConnectionsType;
import org.bandhu.ext.linkedin.jaxb.HttpHeaderType;
import org.bandhu.ext.linkedin.jaxb.JobBookmarkType;
import org.bandhu.ext.linkedin.jaxb.JobBookmarksType;
import org.bandhu.ext.linkedin.jaxb.JobSearchType;
import org.bandhu.ext.linkedin.jaxb.JobSuggestionsType;
import org.bandhu.ext.linkedin.jaxb.MailboxItemType;
import org.bandhu.ext.linkedin.jaxb.PeopleSearchType;
import org.bandhu.ext.linkedin.jaxb.PersonType;
import org.bandhu.ext.linkedin.jaxb.ProductsType;
import org.bandhu.ext.linkedin.jaxb.ShareType;
import org.bandhu.ext.linkedin.jaxb.UpdatesType;
import org.bandhu.ext.linkedin.service.LinkedInSPService;
import org.bandhu.ext.linkedin.util.JobFilter;
import org.bandhu.ext.linkedin.util.LinkedInException;
import org.bandhu.ext.linkedin.util.LinkedInXMLBuilder;
import org.bandhu.ext.linkedin.util.PersonFilter;
import org.bandhu.ext.linkedin.util.UpdateFilter;
import org.bandhu.util.BandhuException;

import com.sun.jersey.api.client.ClientResponse;

public class LinkedInService {

    public static final int STATUS_SUCCESS = 200;

    private OAuthService service;

    public LinkedInService(OAuthService service) {
        this.service = service;
    }

    public boolean sendInvite(MailboxItemType mailboxItemType)
            throws BandhuException {
        LinkedInSPService sendMessage = LinkedInSPService.POSTING_MESSAGE;
        OAuthRequest msgRequest = service.createRequest(sendMessage);
        msgRequest.setPayload(LinkedInXMLBuilder.toXML(mailboxItemType));
        ClientResponse resp = service.process(msgRequest);
        handle(resp);
        return true;
    }

    public boolean sendMessage(MailboxItemType mailboxItemType)
            throws BandhuException {
        LinkedInSPService sendMessage = LinkedInSPService.POSTING_MESSAGE;
        OAuthRequest msgRequest = service.createRequest(sendMessage);
        msgRequest.setPayload(LinkedInXMLBuilder.toXML(mailboxItemType));
        ClientResponse resp = service.process(msgRequest);
        handle(resp);
        return true;
    }

    public boolean postShare(ShareType shareType) throws BandhuException {
        LinkedInSPService jobSuggestion = LinkedInSPService.POSTING_SHARES;
        OAuthRequest postRequest = service.createRequest(jobSuggestion);
        postRequest.setPayload(LinkedInXMLBuilder.toXML(shareType));
        ClientResponse resp = service.process(postRequest);
        handle(resp);
        return true;
    }

    public JobSuggestionsType suggestJobs() throws BandhuException {
        LinkedInSPService jobSuggestion = LinkedInSPService.JOB_SUGGESTION;
        OAuthRequest suggestRequest = service.createRequest(jobSuggestion);
        ClientResponse resp = service.process(suggestRequest);
        handle(resp);
        return resp.getEntity(JobSuggestionsType.class);
    }

    public JobBookmarksType getBookmarkedJobs() throws BandhuException {
        LinkedInSPService jobBookmarked = LinkedInSPService.JOB_BOOKMARKED;
        OAuthRequest getBookmarksRequest = service.createRequest(jobBookmarked);
        ClientResponse resp = service.process(getBookmarksRequest);
        handle(resp);
        return resp.getEntity(JobBookmarksType.class);
    }

    public boolean bookmarkJob(JobBookmarkType jobBookmark)
            throws BandhuException {
        LinkedInSPService jobBookmarkService = LinkedInSPService.JOB_BOOKMARK;
        OAuthRequest bookmarkRequest = service
                .createRequest(jobBookmarkService);
        bookmarkRequest.setPayload(LinkedInXMLBuilder.toXML(jobBookmark));
        ClientResponse resp = service.process(bookmarkRequest);
        handle(resp);
        return true;
    }

    public JobSearchType searchJob(JobFilter jobFilter) throws BandhuException {
        LinkedInSPService jobSearch = LinkedInSPService.JOB_SEARCH;
        OAuthRequest searchRequest = service.createRequest(jobSearch, null,
                jobFilter.toString());
        ClientResponse resp = service.process(searchRequest);
        handle(resp);
        return resp.getEntity(JobSearchType.class);
    }

    public ProductsType getCompanyProducts(String companyId)
            throws BandhuException {
        LinkedInSPService companyProducts = LinkedInSPService.COMPANY_PRODUCTS;
        OAuthRequest companyProductsRequest = service.createRequest(
                companyProducts, null, companyId);
        ClientResponse resp = service.process(companyProductsRequest);
        handle(resp);
        return resp.getEntity(ProductsType.class);
    }

    public CompaniesType suggestCompanies() throws BandhuException {
        LinkedInSPService companySuggestions = LinkedInSPService.COMPANY_SUGGESTION;
        OAuthRequest request = service.createRequest(companySuggestions);
        ClientResponse resp = service.process(request);
        handle(resp);
        return resp.getEntity(CompaniesType.class);
    }

    public CompaniesType getFollowingCompanies() throws BandhuException {
        LinkedInSPService followingCompanies = LinkedInSPService.COMPANY_FOLLOWED;
        OAuthRequest req = service.createRequest(followingCompanies);
        ClientResponse resp = service.process(req);
        handle(resp);
        return resp.getEntity(CompaniesType.class);
    }

    public boolean followCompany(CompanyType companyType)
            throws BandhuException {
        LinkedInSPService followCompany = LinkedInSPService.COMPANY_FOLLOW;
        OAuthRequest request = service.createRequest(followCompany);
        request.setPayload(LinkedInXMLBuilder.toXML(companyType));
        ClientResponse resp = service.process(request);
        handle(resp);
        return true;
    }

    public boolean unfollowCompany(CompanyType companyType)
            throws BandhuException {
        LinkedInSPService followCompany = LinkedInSPService.COMPANY_UNFOLLOW;
        OAuthRequest request = service.createRequest(followCompany, null,
                String.valueOf(companyType.getId()));
        ClientResponse resp = service.process(request);
        handle(resp);
        return true;
    }

    public CompaniesType searchCompany(String keywords) throws BandhuException {
        LinkedInSPService profileSelect = LinkedInSPService.COMPANY_SEARCH;
        OAuthRequest request = service.createRequest(profileSelect, null,
                keywords);
        ClientResponse resp = service.process(request);
        handle(resp);
        return resp.getEntity(CompaniesType.class);
    }

    public UpdatesType fetchUpdates() throws BandhuException {
        return fetchUpdates(null);
    }

    public UpdatesType fetchUpdates(UpdateFilter updateFilter)
            throws BandhuException {
        LinkedInSPService updates = LinkedInSPService.UPDATES;
        OAuthRequest req = null;
        if (updateFilter == null)
            req = service.createRequest(updates);
        else
            req = service.createRequest(updates, updateFilter.toString());
        ClientResponse resp = service.process(req);
        handle(resp);
        return resp.getEntity(UpdatesType.class);
    }

    public ConnectionsType fetchConnections() throws BandhuException {
        LinkedInSPService connections = LinkedInSPService.CONNECTIONS;
        OAuthRequest req = service.createRequest(connections);
        ClientResponse resp = service.process(req);
        handle(resp);
        return resp.getEntity(ConnectionsType.class);
    }

    public ConnectionsType fetchConnectionsSelect(PersonType personType)
            throws BandhuException {
        LinkedInSPService connections = LinkedInSPService.CONNECTIONS_SELECT;
        OAuthRequest req = service.createRequest(connections, null,
                personType.getId());
        HttpHeaderType httpHeaderType = personType
                .getApiStandardProfileRequest().getHeaders().getHttpHeader()
                .get(0);
        req.addHeaderValue(httpHeaderType.getName(), httpHeaderType.getValue());
        ClientResponse resp = service.process(req);
        handle(resp);
        return resp.getEntity(ConnectionsType.class);
    }

    public PeopleSearchType searchPeople(PersonFilter searchPerson)
            throws BandhuException {
        LinkedInSPService search = LinkedInSPService.SEARCH;
        OAuthRequest req = service.createRequest(search, null,
                searchPerson.toString());
        ClientResponse resp = service.process(req);
        handle(resp);
        return resp.getEntity(PeopleSearchType.class);
    }

    public PersonType getProfile(PersonType person) throws BandhuException {
        OAuthRequest req = null;
        if (person != null) {
            String id = person.getId();
            HttpHeaderType httpHeader = null;
            for (HttpHeaderType httpHdr : person.getApiStandardProfileRequest()
                    .getHeaders().getHttpHeader()) {
                httpHeader = httpHdr;
            }
            if (!httpHeader.getName().contains("OUT")) {
                req = getProfileSelectConnected(id, httpHeader.getName(),
                        httpHeader.getValue());

            } else {
                req = getProfileSelect(id, httpHeader.getName(),
                        httpHeader.getValue());
            }
        } else {
            req = getProfileReq();
        }
        ClientResponse resp = service.process(req);
        handle(resp);
        return resp.getEntity(PersonType.class);
    }

    public OAuthRequest getProfileReq() throws BandhuException {
        LinkedInSPService profile = LinkedInSPService.PROFILE;
        OAuthRequest req = service.createRequest(profile);
        return req;
    }

    public PersonType getProfile() throws BandhuException {
        LinkedInSPService profile = LinkedInSPService.PROFILE;
        OAuthRequest req = service.createRequest(profile);
        ClientResponse resp = service.process(req);
        handle(resp);
        return resp.getEntity(PersonType.class);
    }

    private OAuthRequest getProfileSelect(String id, String headerName,
            String headerValue) throws BandhuException {
        LinkedInSPService profileSelect = LinkedInSPService.PROFILE_SELECT;
        OAuthRequest req = service.createRequest(profileSelect, null, id);
        req.addHeaderValue(headerName, headerValue);
        return req;
    }

    private OAuthRequest getProfileSelectConnected(String id,
            String headerName, String headerValue) throws BandhuException {
        LinkedInSPService profileSelect = LinkedInSPService.PROFILE_SELECT_CONNECTED;
        OAuthRequest req = service.createRequest(profileSelect, null, id);
        req.addHeaderValue(headerName, headerValue);
        return req;

    }

    public static final String PROCESS_FAILURE = "Unable to process the request!";

    public static void handle(ClientResponse response) throws LinkedInException {
        if (response.getStatus() != STATUS_SUCCESS) {
            throw new LinkedInException(PROCESS_FAILURE);
        }
    }
}
