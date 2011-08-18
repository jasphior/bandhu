package org.bandhu.ext.linkedin.util;

public class LinkedInUtil {
    public static final String PROFILE = "id,first-name,last-name,headline,picture-url,location,api-standard-profile-request,site-standard-profile-request,distance,relation-to-viewer,num-connections,positions,educations";
    public static final String PROFILE_BASIC = "id,first-name,last-name,headline,picture-url,location,api-standard-profile-request,site-standard-profile-request,distance,relation-to-viewer,num-connections";
    public static final String PROFILE_FULL = "id,first-name,last-name,headline,picture-url,location,industry,current-share,summary,specialties,proposal-comments,associations,honors,interests,publications,patents,languages,skills,certifications,num-recommenders,recommendations-received,phone-numbers,im-accounts,twitter-accounts,date-of-birth,main-address,member-url-resources,api-standard-profile-request,site-standard-profile-request,distance,relation-to-viewer,num-connections,connections,positions,educations";
    public static final String COMPANY = "id,name,universal-name,website-url,industries,status,logo-url,blog-rss-url,twitter-id,employee-count-range,specialties,locations,description,stock-exchange,founded-year,end-year,num-followers";
    public static final String PRODUCT = "id,name,type,creation-timestamp,logo-url,description,features,video:(title,url),product-deal:(title,url,text),sales-persons,num-recommendations,recommendations:(recommender,id,product-id,text,reply,timestamp,likes:(timestamp,person)),product-category,website-url,disclaimer";
    public static final String JOB = "id,customer-job-code,active,posting-date,expiration-date,posting-timestamp,company:(id,name),position:(title,location,job-functions,industries,job-type,experience-level),skills-and-experience,description-snippet,description,salary,job-poster:(id,first-name,last-name,headline),referral-bonus,site-job-url,location-description";

}
