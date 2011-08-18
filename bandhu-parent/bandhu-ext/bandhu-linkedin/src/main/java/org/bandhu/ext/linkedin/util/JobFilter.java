package org.bandhu.ext.linkedin.util;

public class JobFilter extends Filter {

    /** company-name=[company-name] */
    private String companyName;
    /** job-title=[job-title] */
    private String jobTitle;

    String getCompanyName() {
        return companyName;
    }

    void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    String getJobTitle() {
        return jobTitle;
    }

    void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        if (companyName != null) {
            builder.append("company-name=");
            builder.append(companyName);
            builder.append(SEPERATOR);
        }
        if (jobTitle != null) {
            builder.append("job-title=");
            builder.append(jobTitle);
            builder.append(SEPERATOR);
        }
        return builder.toString();
    }
}
