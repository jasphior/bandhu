package org.bandhu.ext.linkedin.util;

public class LinkedInFilter {

    public static final String seperator = "&";

    public enum Sort {
        connections, recommenders, distance, relevance
    }

    /** keywords=[space delimited keywords] */
    protected String keywords;
    /** country-code=[country code] */
    protected String countryCode;
    /** postal-code=[postal code] */
    protected String postalCode;
    /** distance=[miles] */
    protected Long distance;
    /** start=[number] */
    protected Integer start;
    /** count=[1-25] */
    protected Integer count;
    /** sort=[connections|recommenders|distance|relevance] */
    protected Sort sort;

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (keywords != null) {
            builder.append("keywords=");
            builder.append(keywords);
            builder.append(seperator);
        }
        if (countryCode != null) {
            builder.append("country-code=");
            builder.append(countryCode);
            builder.append(seperator);
        }
        if (postalCode != null) {
            builder.append("postal-code=");
            builder.append(postalCode);
            builder.append(seperator);
        }
        if (distance != null) {
            builder.append("distance=");
            builder.append(distance);
            builder.append(seperator);
        }
        if (start != null) {
            builder.append("start=");
            builder.append(start);
            builder.append(seperator);
        }
        if (count != null) {
            builder.append(", count=");
            builder.append(count);
            builder.append(seperator);
        }
        if (sort != null) {
            builder.append("sort=");
            builder.append(sort);
            builder.append(seperator);
        }
        return builder.toString();
    }
}
