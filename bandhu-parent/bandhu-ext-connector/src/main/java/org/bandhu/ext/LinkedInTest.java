package org.bandhu.ext;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.Properties;
import java.util.Scanner;

import org.bandhu.core.rest.oauth.OAuthConsumer;
import org.bandhu.core.rest.oauth.OAuthRequest;
import org.bandhu.core.rest.oauth.OAuthService;
import org.bandhu.core.rest.oauth.OAuthToken;
import org.bandhu.ext.linkedin.jaxb.ConnectionsType;
import org.bandhu.ext.linkedin.jaxb.HttpHeaderType;
import org.bandhu.ext.linkedin.jaxb.PeopleSearchType;
import org.bandhu.ext.linkedin.jaxb.PersonType;
import org.bandhu.ext.linkedin.jaxb.UpdateType;
import org.bandhu.ext.linkedin.jaxb.UpdatesType;
import org.bandhu.ext.linkedin.service.LinkedInSP;
import org.bandhu.ext.linkedin.service.LinkedInSPServices;
import org.bandhu.ext.linkedin.util.JobFilter;
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
            System.out.println("Useing session...");
            service = new OAuthService(oAuthConsumer, LinkedInSP.class);
            OAuthToken accessToken = new OAuthToken(
                    properties.getProperty(OAuthParameters.TOKEN),
                    properties.getProperty(OAuthParameters.TOKEN_SECRET));
            service.setAccessToken(accessToken);
        } else {
            service = new OAuthService(oAuthConsumer, LinkedInSP.class);
            verifyGetAccessToken(service);
        }
        // fetchUpdates(service);
        // searchPeople(service);
        // getProfile(service);
        // getProfileSelect(service);
        // fetchConnections(service);
        // fetchConnectionsSelect(service); Access to other member's connections
        // denied
        // searchCompany(service);
        // getProfileSelect(service, "U01_u5N6FY", "x-li-auth-token",
        // "name:8VOX");
        // suggestCompanies(service);
        // fetchCompanyProducts(service);
        // findJobs(service);
        // getBookmarkedJobs(service);
        suggestJobs(service);
    }

    private static void suggestJobs(OAuthService service)
            throws BandhuException {
        LinkedInSPServices jobSuggestion = LinkedInSPServices.JOB_SUGGESTION;
        OAuthRequest updateRequest = service.createRequest(jobSuggestion);
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void getBookmarkedJobs(OAuthService service)
            throws BandhuException {
        LinkedInSPServices jobBookmarked = LinkedInSPServices.JOB_BOOKMARKED;
        OAuthRequest updateRequest = service.createRequest(jobBookmarked);
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void findJobs(OAuthService service) throws BandhuException {
        LinkedInSPServices jobSearch = LinkedInSPServices.JOB_SEARCH;
        JobFilter jobFilter = new JobFilter();
        jobFilter.setCountryCode("in");
        OAuthRequest updateRequest = service.createRequest(jobSearch, null,
                jobFilter.toString());
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void fetchCompanyProducts(OAuthService service)
            throws BandhuException {
        LinkedInSPServices companyProducts = LinkedInSPServices.COMPANY_PRODUCTS;
        OAuthRequest updateRequest = service.createRequest(companyProducts,
                null, "4301");
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void suggestCompanies(OAuthService service)
            throws BandhuException {
        LinkedInSPServices companySuggestions = LinkedInSPServices.COMPANY_SUGGESTION;
        OAuthRequest updateRequest = service.createRequest(companySuggestions);
        ClientResponse resp = service.process(updateRequest);
        System.out.println(resp.getEntity(String.class));
    }

    private static void searchCompany(OAuthService service)
            throws BandhuException {
        LinkedInSPServices profileSelect = LinkedInSPServices.COMPANY_SEARCH;
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
        LinkedInSPServices profileSelect = LinkedInSPServices.UPDATES;
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
        LinkedInSPServices profileSelect = LinkedInSPServices.CONNECTIONS;
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
        LinkedInSPServices profileSelect = LinkedInSPServices.CONNECTIONS_SELECT;
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
        LinkedInSPServices profileSelect = LinkedInSPServices.SEARCH;
        PersonFilter searchPerson = new PersonFilter();
        searchPerson.setKeywords("Gopinath");
        searchPerson.setCompanyName("Symphony Services");
        searchPerson.setCurrentCompany(true);
        OAuthRequest updateRequest = service.createRequest(profileSelect,
                param, searchPerson.toString());
        ClientResponse resp = service.process(updateRequest);
        // System.out.println(resp.getEntity(String.class));
        PeopleSearchType type = resp.getEntity(PeopleSearchType.class);
        System.out.println(type);
        int start = type.getPeople().getStart() != null ? type.getPeople()
                .getStart() : 1;
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
        LinkedInSPServices profile = LinkedInSPServices.PROFILE;
        OAuthRequest profileRequest = service.createRequest(profile);
        ClientResponse resp = service.process(profileRequest);

        // System.out.println(resp.getEntity(String.class));

        PersonType person = resp.getEntity(PersonType.class);

        // getProfilePublic(service, person);
        getProfileSelect(service, person);
    }

    private static void getProfilePublic(OAuthService service, PersonType person)
            throws BandhuException {
        String url = person.getSiteStandardProfileRequest().getUrl();
        System.out.println(url);
        LinkedInSPServices profileSelect = LinkedInSPServices.PROFILE_PUBLIC;
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
        LinkedInSPServices profileSelect = LinkedInSPServices.PROFILE_SELECT;
        OAuthRequest updateRequest = service.createRequest(profileSelect, null,
                id);
        updateRequest.addHeaderValue(headerName, headerValue);
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
