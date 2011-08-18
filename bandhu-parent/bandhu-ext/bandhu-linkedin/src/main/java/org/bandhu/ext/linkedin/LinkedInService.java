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

    public static final int STATUS_SUCCESS = 201;

    public boolean sendInvite(OAuthService service,
            MailboxItemType mailboxItemType) throws BandhuException {
        LinkedInSPService sendMessage = LinkedInSPService.POSTING_MESSAGE;
        OAuthRequest msgRequest = service.createRequest(sendMessage);
        msgRequest.setPayload(LinkedInXMLBuilder.toXML(mailboxItemType));
        ClientResponse resp = service.process(msgRequest);
        handle(resp);
        return true;
    }

    public boolean sendMessage(OAuthService service,
            MailboxItemType mailboxItemType) throws BandhuException {
        LinkedInSPService sendMessage = LinkedInSPService.POSTING_MESSAGE;
        OAuthRequest msgRequest = service.createRequest(sendMessage);
        msgRequest.setPayload(LinkedInXMLBuilder.toXML(mailboxItemType));
        ClientResponse resp = service.process(msgRequest);
        handle(resp);
        return true;
    }

    public boolean postShare(OAuthService service, ShareType shareType)
            throws BandhuException {
        LinkedInSPService jobSuggestion = LinkedInSPService.POSTING_SHARES;
        OAuthRequest postRequest = service.createRequest(jobSuggestion);
        postRequest.setPayload(LinkedInXMLBuilder.toXML(shareType));
        ClientResponse resp = service.process(postRequest);
        handle(resp);
        return true;
    }

    public JobSuggestionsType suggestJobs(OAuthService service)
            throws BandhuException {
        LinkedInSPService jobSuggestion = LinkedInSPService.JOB_SUGGESTION;
        OAuthRequest suggestRequest = service.createRequest(jobSuggestion);
        ClientResponse resp = service.process(suggestRequest);
        handle(resp);
        return resp.getEntity(JobSuggestionsType.class);
    }

    public JobBookmarksType getBookmarkedJobs(OAuthService service)
            throws BandhuException {
        LinkedInSPService jobBookmarked = LinkedInSPService.JOB_BOOKMARKED;
        OAuthRequest getBookmarksRequest = service.createRequest(jobBookmarked);
        ClientResponse resp = service.process(getBookmarksRequest);
        handle(resp);
        return resp.getEntity(JobBookmarksType.class);
    }

    public boolean bookmarkJob(OAuthService service, JobBookmarkType jobBookmark)
            throws BandhuException {
        LinkedInSPService jobBookmarkService = LinkedInSPService.JOB_BOOKMARK;
        OAuthRequest bookmarkRequest = service
                .createRequest(jobBookmarkService);
        bookmarkRequest.setPayload(LinkedInXMLBuilder.toXML(jobBookmark));
        ClientResponse resp = service.process(bookmarkRequest);
        handle(resp);
        return true;
    }

    public JobSearchType searchJob(OAuthService service, JobFilter jobFilter)
            throws BandhuException {
        LinkedInSPService jobSearch = LinkedInSPService.JOB_SEARCH;
        OAuthRequest searchRequest = service.createRequest(jobSearch, null,
                jobFilter.toString());
        ClientResponse resp = service.process(searchRequest);
        handle(resp);
        return resp.getEntity(JobSearchType.class);
    }

    public ProductsType getCompanyProducts(OAuthService service,
            String companyId) throws BandhuException {
        LinkedInSPService companyProducts = LinkedInSPService.COMPANY_PRODUCTS;
        OAuthRequest companyProductsRequest = service.createRequest(
                companyProducts, null, companyId);
        ClientResponse resp = service.process(companyProductsRequest);
        handle(resp);
        return resp.getEntity(ProductsType.class);
    }

    public CompaniesType suggestCompanies(OAuthService service)
            throws BandhuException {
        LinkedInSPService companySuggestions = LinkedInSPService.COMPANY_SUGGESTION;
        OAuthRequest updateRequest = service.createRequest(companySuggestions);
        ClientResponse resp = service.process(updateRequest);
        handle(resp);
        return resp.getEntity(CompaniesType.class);
    }

    public CompaniesType getFollowingCompanies(OAuthService service)
            throws BandhuException {
        LinkedInSPService followingCompanies = LinkedInSPService.COMPANY_FOLLOWED;
        OAuthRequest req = service.createRequest(followingCompanies);
        ClientResponse resp = service.process(req);
        handle(resp);
        return resp.getEntity(CompaniesType.class);
    }

    public boolean followCompany(OAuthService service, CompanyType companyType)
            throws BandhuException {
        LinkedInSPService followCompany = LinkedInSPService.COMPANY_FOLLOW;
        OAuthRequest updateRequest = service.createRequest(followCompany);
        updateRequest.setPayload(LinkedInXMLBuilder.toXML(companyType));
        ClientResponse resp = service.process(updateRequest);
        handle(resp);
        return true;
    }

    public boolean unfollowCompany(OAuthService service, CompanyType companyType)
            throws BandhuException {
        LinkedInSPService followCompany = LinkedInSPService.COMPANY_UNFOLLOW;
        OAuthRequest updateRequest = service.createRequest(followCompany, null,
                String.valueOf(companyType.getId()));
        ClientResponse resp = service.process(updateRequest);
        handle(resp);
        return true;
    }

    public CompaniesType searchCompany(OAuthService service, String keywords)
            throws BandhuException {
        LinkedInSPService profileSelect = LinkedInSPService.COMPANY_SEARCH;
        OAuthRequest updateRequest = service.createRequest(profileSelect, null,
                keywords);
        ClientResponse resp = service.process(updateRequest);
        handle(resp);
        return resp.getEntity(CompaniesType.class);
    }

    public UpdatesType fetchUpdates(OAuthService service)
            throws BandhuException {
        return fetchUpdates(service, null);
    }

    public UpdatesType fetchUpdates(OAuthService service,
            UpdateFilter updateFilter) throws BandhuException {
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

    public ConnectionsType fetchConnections(OAuthService service)
            throws BandhuException {
        LinkedInSPService connections = LinkedInSPService.CONNECTIONS;
        OAuthRequest req = service.createRequest(connections);
        ClientResponse resp = service.process(req);
        handle(resp);
        return resp.getEntity(ConnectionsType.class);
    }

    public ConnectionsType fetchConnectionsSelect(OAuthService service,
            PersonType personType) throws BandhuException {
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

    public PeopleSearchType searchPeople(OAuthService service,
            PersonFilter searchPerson) throws BandhuException {
        LinkedInSPService search = LinkedInSPService.SEARCH;
        OAuthRequest req = service.createRequest(search, null,
                searchPerson.toString());
        ClientResponse resp = service.process(req);
        handle(resp);
        return resp.getEntity(PeopleSearchType.class);
    }

    public PersonType getProfile(OAuthService service, PersonType person)
            throws BandhuException {
        OAuthRequest req = null;
        if (person != null) {
            String id = person.getId();
            HttpHeaderType httpHeader = null;
            for (HttpHeaderType httpHdr : person.getApiStandardProfileRequest()
                    .getHeaders().getHttpHeader()) {
                httpHeader = httpHdr;
            }
            if (!httpHeader.getName().contains("OUT")) {
                req = getProfileSelectConnected(service, id,
                        httpHeader.getName(), httpHeader.getValue());

            } else {
                req = getProfileSelect(service, id, httpHeader.getName(),
                        httpHeader.getValue());
            }
        } else {
            req = getProfile(service);
        }
        ClientResponse resp = service.process(req);
        handle(resp);
        return resp.getEntity(PersonType.class);
    }

    private OAuthRequest getProfile(OAuthService service)
            throws BandhuException {
        LinkedInSPService profile = LinkedInSPService.PROFILE;
        OAuthRequest req = service.createRequest(profile);
        return req;
    }

    private OAuthRequest getProfileSelect(OAuthService service, String id,
            String headerName, String headerValue) throws BandhuException {
        LinkedInSPService profileSelect = LinkedInSPService.PROFILE_SELECT;
        OAuthRequest req = service.createRequest(profileSelect, null, id);
        req.addHeaderValue(headerName, headerValue);
        return req;
    }

    private OAuthRequest getProfileSelectConnected(OAuthService service,
            String id, String headerName, String headerValue)
            throws BandhuException {
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
