package org.bandhu.ext.linkedin.util;

public class Filter {

    public static final String SEPERATOR = "&";

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

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
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
            builder.append(SEPERATOR);
        }
        if (countryCode != null) {
            builder.append("country-code=");
            builder.append(countryCode);
            builder.append(SEPERATOR);
        }
        if (postalCode != null) {
            builder.append("postal-code=");
            builder.append(postalCode);
            builder.append(SEPERATOR);
        }
        if (distance != null) {
            builder.append("distance=");
            builder.append(distance);
            builder.append(SEPERATOR);
        }
        if (start != null) {
            builder.append("start=");
            builder.append(start);
            builder.append(SEPERATOR);
        }
        if (count != null) {
            builder.append(", count=");
            builder.append(count);
            builder.append(SEPERATOR);
        }
        if (sort != null) {
            builder.append("sort=");
            builder.append(sort);
            builder.append(SEPERATOR);
        }
        return builder.toString();
    }
}
