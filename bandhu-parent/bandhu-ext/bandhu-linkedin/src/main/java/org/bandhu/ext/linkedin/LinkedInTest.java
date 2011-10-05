package org.bandhu.ext.linkedin;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.Properties;
import java.util.Scanner;

import org.bandhu.core.rest.oauth.OAuthConsumer;
import org.bandhu.core.rest.oauth.OAuthRequest;
import org.bandhu.core.rest.oauth.OAuthService;
import org.bandhu.core.rest.oauth.OAuthToken;
import org.bandhu.ext.linkedin.jaxb.AuthorizationType;
import org.bandhu.ext.linkedin.jaxb.ConnectionsType;
import org.bandhu.ext.linkedin.jaxb.HttpHeaderType;
import org.bandhu.ext.linkedin.jaxb.InvitationRequestType;
import org.bandhu.ext.linkedin.jaxb.ItemContentType;
import org.bandhu.ext.linkedin.jaxb.JobBookmarkType;
import org.bandhu.ext.linkedin.jaxb.JobType;
import org.bandhu.ext.linkedin.jaxb.MailboxItemType;
import org.bandhu.ext.linkedin.jaxb.PeopleSearchType;
import org.bandhu.ext.linkedin.jaxb.PersonType;
import org.bandhu.ext.linkedin.jaxb.RecipientType;
import org.bandhu.ext.linkedin.jaxb.RecipientsType;
import org.bandhu.ext.linkedin.jaxb.UpdateType;
import org.bandhu.ext.linkedin.jaxb.UpdatesType;
import org.bandhu.ext.linkedin.service.LinkedInSP;
import org.bandhu.ext.linkedin.service.LinkedInSPService;
import org.bandhu.ext.linkedin.util.JobFilter;
import org.bandhu.ext.linkedin.util.LinkedInXMLBuilder;
import org.bandhu.ext.linkedin.util.PersonFilter;
import org.bandhu.util.BandhuException;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.oauth.signature.OAuthParameters;

public class LinkedInTest {
    static {
        // System.setProperty("http.proxyHost", "proxy.symphonysv.com");
        // System.setProperty("http.proxyPort", "8080");
        // System.setProperty("https.proxyHost", "proxy.symphonysv.com");
        // System.setProperty("https.proxyPort", "8080");
    }

    static Properties properties;
    static String configName = "jlinkedin.properties";
    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(configName));
            System.out.println("loaded..");
            System.out.println(properties);
            // BandhuConfig.setServiceResolver(ServiceID)
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static OAuthToken token;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws BandhuException {
        OAuthService service = null;
        OAuthConsumer oAuthConsumer = new OAuthConsumer(
                "OzUfPltBulcBKrxe98N0UW6gQv2WlyJCR_DOARgLEdlNpNuiVm26ArHRDKOlP0S0",
                "JhM8fPGReAvtlMNpeT9srxIF0kU6KBXovLeqb6gq0-PK-jfDn8m8k8CzUFDR9U0o");

        System.out.println("Use existing session? (y/n)");

        String option = "y";
        // scanner.nextLine();
        if (Boolean.valueOf(option.equals("y"))) {
            System.out.println("Using session...");
            service = new OAuthService(oAuthConsumer, LinkedInSP.class);
            OAuthToken accessToken = new OAuthToken(
                    properties.getProperty(OAuthParameters.TOKEN),
                    properties.getProperty(OAuthParameters.TOKEN_SECRET));
            service.setAccessToken(accessToken);
        } else {
            service = new OAuthService(oAuthConsumer, LinkedInSP.class);
            verifyGetAccessToken(service);
        }
        fetchUpdates(service);
        System.out.println("-------------------------------------");
        getProfile(service);
        getProfileSelect(service, "bXJUPUibw6", "x-li-auth-token",
                "OUT_OF_NETWORK:wz1i");

        String s = "y";
        do {
            System.out.println("feed id & header value");
            getProfileSelectConnected(service, scanner.nextLine(),
                    "x-li-auth-token", scanner.nextLine());
            System.out.println("dig more??");
        } while (scanner.nextLine().equals(s));

        getProfileSelect(service, "NxMAvPejV7", "x-li-auth-token",
                "OUT_OF_NETWORK:iT34");
        getProfileSelectPublic(service,
                "http://api.linkedin.com/v1/people/X5Nwi4gEPk");
        fetchConnections(service);
        fetchConnectionsSelect(service);
        // Access to other member's connections denied
        searchPeople(service);
        searchCompany(service);
        searchJob(service);
        fetchCompanyProducts(service);
        getBookmarkedJobs(service);
        bookmarkJob(service);
        suggestCompanies(service);
        suggestJobs(service);
        postShare(service);
        sendMessage(service);
        sendInvite(service);
    }

    private static void sendInvite(OAuthService service) throws BandhuException {

        MailboxItemType mailbox = new MailboxItemType();
        RecipientsType recipients = new RecipientsType();
        RecipientType recipient = new RecipientType();
        PersonType person = new PersonType();
        recipient.setPerson(person);
        person.setPath("/people/id=vIlO2NShsA");
        recipients.setRecipient(recipient);
        mailbox.setRecipients(recipients);
        mailbox.setSubject("Invitation to join my network!!");
        mailbox.setBody("Hi!! I would like to add you to my network!!");
        ItemContentType itemContent = new ItemContentType();
        InvitationRequestType invite = new InvitationRequestType();
        invite.setConnectType("friend");
        if (person.getPath().indexOf("email") == -1) {
            AuthorizationType auth = new AuthorizationType();
            auth.setName("OUT_OF_NETWORK");
            auth.setValue("4Ghv");
            invite.setAuthorization(auth);
        }
        itemContent.setInvitationRequest(invite);
        mailbox.setItemContent(itemContent);
        LinkedInSPService sendMessage = LinkedInSPService.POSTING_MESSAGE;
        OAuthRequest msgRequest = service.createRequest(sendMessage);
        msgRequest.setPayload(LinkedInXMLBuilder.toXML(mailbox));
        ClientResponse resp = service.process(msgRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void sendMessage(OAuthService service)
            throws BandhuException {

        MailboxItemType mailbox = new MailboxItemType();
        RecipientsType recipients = new RecipientsType();
        RecipientType recipient = new RecipientType();
        PersonType person = new PersonType();
        recipient.setPerson(person);
        person.setPath("/people/0ec6IiNQNN");
        // person.setFirstName("Gopinath");
        // person.setLastName("Lappasi");
        recipients.setRecipient(recipient);
        mailbox.setRecipients(recipients);
        mailbox.setSubject("API Msg!!");
        mailbox.setBody("Hi Gopi!!");

        LinkedInSPService sendMessage = LinkedInSPService.POSTING_MESSAGE;
        OAuthRequest msgRequest = service.createRequest(sendMessage);
        msgRequest.setPayload(LinkedInXMLBuilder.toXML(mailbox));
        ClientResponse resp = service.process(msgRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void postShare(OAuthService service) throws BandhuException {
        LinkedInSPService jobSuggestion = LinkedInSPService.POSTING_SHARES;
        OAuthRequest updateRequest = service.createRequest(jobSuggestion);
        updateRequest
                .setPayload("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
                        + " <share> <comment>83% of employers will use social media to hire: 78% LinkedIn, 55% Facebook, 45% Twitter [SF Biz Times] http://bit.ly/cCpeOD</comment>"
                        + " <content> <title>Survey: Social networks top hiring tool - San Francisco Business Times</title> "
                        + "<submitted-url>http://sanfrancisco.bizjournals.com/sanfrancisco/stories/2010/06/28/daily34.html</submitted-url>"
                        + " <submitted-image-url>http://images.bizjournals.com/travel/cityscapes/thumbs/sm_sanfrancisco.jpg</submitted-image-url>"
                        + "  </content>  <visibility>     <code>anyone</code>  </visibility></share>");
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void suggestJobs(OAuthService service)
            throws BandhuException {
        LinkedInSPService jobSuggestion = LinkedInSPService.JOB_SUGGESTION;
        OAuthRequest updateRequest = service.createRequest(jobSuggestion);
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void getBookmarkedJobs(OAuthService service)
            throws BandhuException {
        LinkedInSPService jobBookmarked = LinkedInSPService.JOB_BOOKMARKED;
        OAuthRequest updateRequest = service.createRequest(jobBookmarked);
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void bookmarkJob(OAuthService service)
            throws BandhuException {

        JobBookmarkType jobBookmark = new JobBookmarkType();
        JobType jobType = new JobType();
        jobType.setId(1745);
        jobBookmark.setJob(jobType);
        LinkedInSPService jobBookmarkService = LinkedInSPService.JOB_BOOKMARK;
        OAuthRequest bookmarkRequest = service
                .createRequest(jobBookmarkService);
        bookmarkRequest.setPayload(LinkedInXMLBuilder.toXML(jobBookmark));
        ClientResponse resp = service.process(bookmarkRequest);

        System.out.println(resp.getEntity(String.class));
    }

    private static void searchJob(OAuthService service) throws BandhuException {
        LinkedInSPService jobSearch = LinkedInSPService.JOB_SEARCH;
        JobFilter jobFilter = new JobFilter();
        jobFilter.setCountryCode("in");
        OAuthRequest updateRequest = service.createRequest(jobSearch, null,
                jobFilter.toString());
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void fetchCompanyProducts(OAuthService service)
            throws BandhuException {
        LinkedInSPService companyProducts = LinkedInSPService.COMPANY_PRODUCTS;
        OAuthRequest updateRequest = service.createRequest(companyProducts,
                null, "4301");
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void suggestCompanies(OAuthService service)
            throws BandhuException {
        LinkedInSPService companySuggestions = LinkedInSPService.COMPANY_SUGGESTION;
        OAuthRequest updateRequest = service.createRequest(companySuggestions);
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void searchCompany(OAuthService service)
            throws BandhuException {
        LinkedInSPService profileSelect = LinkedInSPService.COMPANY_SEARCH;
        OAuthRequest updateRequest = service.createRequest(profileSelect, null,
                "symphony");
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void verifyGetAccessToken(OAuthService service)
            throws BandhuException {
        String authenticationURL = service.getAuthenticationURL();
        System.out.println(authenticationURL);

        service.setVerifier(scanner.nextLine());
        token = service.fetchAccessToken();
        System.out.println(token);
        updateSession(token);
    }

    private static void fetchUpdates(OAuthService service)
            throws BandhuException {
        LinkedInSPService profileSelect = LinkedInSPService.UPDATES;
        OAuthRequest updateRequest = service.createRequest(profileSelect);
        ClientResponse resp = service.process(updateRequest);
        // System.out.println(resp.getEntity(String.class));
        UpdatesType type = resp.getEntity(UpdatesType.class);
        System.out.println("Showing from " + type.getStart() + " to "
                + type.getCount() + " of " + type.getTotal());
        for (UpdateType update : type.getUpdate()) {
            PersonType person = update.getUpdateContent().getPerson();
            System.out.println(person.getFirstName() + ", "
                    + person.getLastName() + ", " + update.getUpdateType());
        }
    }

    private static void fetchConnections(OAuthService service)
            throws BandhuException {
        LinkedInSPService profileSelect = LinkedInSPService.CONNECTIONS;
        OAuthRequest updateRequest = service.createRequest(profileSelect);
        ClientResponse resp = service.process(updateRequest);
        ConnectionsType type = resp.getEntity(ConnectionsType.class);
        System.out.println(type);
        System.out.println("Total: " + type.getTotal());
        for (PersonType person : type.getPerson()) {
            System.out.println(person.getFirstName()
                    + ", "
                    + person.getLastName()
                    + "["
                    + person.getApiStandardProfileRequest().getUrl()
                    + ", "
                    + person.getId()
                    + ", "
                    + person.getApiStandardProfileRequest().getHeaders()
                            .getHttpHeader().get(0).getName()
                    + "-"
                    + person.getApiStandardProfileRequest().getHeaders()
                            .getHttpHeader().get(0).getValue() + "]");
        }
    }

    private static void fetchConnectionsSelect(OAuthService service)
            throws BandhuException {
        LinkedInSPService profileSelect = LinkedInSPService.CONNECTIONS_SELECT;
        OAuthRequest updateRequest = service.createRequest(profileSelect, null,
                "qkh4OapS1r");
        updateRequest.addHeaderValue("x-li-auth-token", "name:97HC");
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void searchPeople(OAuthService service)
            throws BandhuException {
        doSearch(service, "count=25");
    }

    private static void doSearch(OAuthService service, String param)
            throws BandhuException {
        LinkedInSPService profileSelect = LinkedInSPService.SEARCH;
        PersonFilter searchPerson = new PersonFilter();
        searchPerson.setFirstName("pooja");
        OAuthRequest updateRequest = service.createRequest(profileSelect,
                param, searchPerson.toString());
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
        // printSearch(service, resp);
    }

    private static void printSearch(OAuthService service, ClientResponse resp)
            throws BandhuException {
        PeopleSearchType type = resp.getEntity(PeopleSearchType.class);
        System.out.println(type);
        int start = type.getPeople().getStart() != null ? type.getPeople()
                .getStart() : 0;
        int count = type.getPeople().getCount() != null ? type.getPeople()
                .getCount() : type.getPeople().getPerson().size();
        int total = type.getPeople().getTotal() != null ? type.getPeople()
                .getTotal() : type.getPeople().getPerson().size();

        System.out.println("Showing from " + (start + 1) + " to "
                + (count + start) + " of " + total);
        for (PersonType person : type.getPeople().getPerson()) {
            System.out.println(person.getFirstName()
                    + ", "
                    + person.getLastName()
                    + ", ("
                    + person.getDistance()
                    + "["
                    + person.getApiStandardProfileRequest().getUrl()
                    + ", "
                    + person.getId()
                    + ", "
                    + person.getApiStandardProfileRequest().getHeaders()
                            .getHttpHeader().get(0).getName()
                    + "-"
                    + person.getApiStandardProfileRequest().getHeaders()
                            .getHttpHeader().get(0).getValue() + "]");
        }

        boolean flag = start + count < (total - 1);
        if (flag) {
            doSearch(service, "start=" + (start + count) + "&count=" + 25);
        }
    }

    private static void getProfile(OAuthService service) throws BandhuException {
        LinkedInSPService profile = LinkedInSPService.PROFILE;
        OAuthRequest profileRequest = service.createRequest(profile);
        ClientResponse resp = service.process(profileRequest);

        System.out.println(resp.getEntity(String.class));

        // PersonType person = resp.getEntity(PersonType.class);

        // getProfilePublic(service, person);
        // getProfileSelect(service, person);
    }

    private static void getProfilePublic(OAuthService service, PersonType person)
            throws BandhuException {
        String url = person.getSiteStandardProfileRequest().getUrl();
        System.out.println(url);
        LinkedInSPService profileSelect = LinkedInSPService.PROFILE_PUBLIC;
        OAuthRequest updateRequest = service.createRequest(profileSelect, null,
                URLEncoder.encode(url));
        ClientResponse selResponse = service.process(updateRequest);
        System.out.println(selResponse.getEntity(String.class));
    }

    private static void getProfileSelect(OAuthService service, PersonType person)
            throws BandhuException {
        String id = person.getId();
        System.out.println(id);
        HttpHeaderType httpHeader = null;
        for (HttpHeaderType httpHdr : person.getApiStandardProfileRequest()
                .getHeaders().getHttpHeader()) {
            httpHeader = httpHdr;
        }
        getProfileSelect(service, id, httpHeader.getName(),
                httpHeader.getValue());
    }

    private static void getProfileSelect(OAuthService service, String id,
            String headerName, String headerValue) throws BandhuException {
        System.out.println(id);
        LinkedInSPService profileSelect = LinkedInSPService.PROFILE_SELECT;
        OAuthRequest updateRequest = service.createRequest(profileSelect, null,
                id);
        updateRequest.addHeaderValue(headerName, headerValue);
        ClientResponse selResponse = service.process(updateRequest);
        System.out.println(selResponse.getEntity(String.class));
    }

    private static void getProfileSelectConnected(OAuthService service,
            String id, String headerName, String headerValue)
            throws BandhuException {
        System.out.println(id);
        LinkedInSPService profileSelect = LinkedInSPService.PROFILE_SELECT_CONNECTED;
        OAuthRequest updateRequest = service.createRequest(profileSelect, null,
                id);
        updateRequest.addHeaderValue(headerName, headerValue);
        ClientResponse selResponse = service.process(updateRequest);
        System.out.println(selResponse.getEntity(String.class));
    }

    private static void getProfileSelect(OAuthService service, String id)
            throws BandhuException {
        System.out.println(id);
        LinkedInSPService profileSelect = LinkedInSPService.PROFILE_SELECT;
        OAuthRequest updateRequest = service.createRequest(profileSelect, null,
                id);
        ClientResponse selResponse = service.process(updateRequest);
        System.out.println(selResponse.getEntity(String.class));
    }

    private static void getProfileSelectPublic(OAuthService service, String url)
            throws BandhuException {
        System.out.println(url);
        LinkedInSPService profileSelect = LinkedInSPService.PROFILE_PUBLIC;
        OAuthRequest updateRequest = service.createRequest(profileSelect, null,
                URLEncoder.encode(url));
        ClientResponse selResponse = service.process(updateRequest);
        System.out.println(selResponse.getEntity(String.class));
    }

    private static void updateSession(OAuthToken token) {
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
