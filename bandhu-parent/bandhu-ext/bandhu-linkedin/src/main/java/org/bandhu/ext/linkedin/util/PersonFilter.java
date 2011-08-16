package org.bandhu.ext.linkedin.util;

public class PersonFilter extends LinkedInFilter {

    /** first-name=[first name] */
    private String firstName;
    /** last-name=[last name] */
    private String lastName;
    /** company-name=[company name] */
    private String companyName;
    /** current-company=[true|false] */
    private boolean currentCompany;
    /** title=[title] */
    private String title;
    /** current-title=[true|false] */
    private boolean currentTitle;
    /** school-name=[school name] */
    private String schoolName;
    /** current-school=[true|false] */
    private boolean currentSchool;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean isCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(boolean currentCompany) {
        this.currentCompany = currentCompany;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getCurrentTitle() {
        return currentTitle;
    }

    public void setCurrentTitle(boolean currentTitle) {
        this.currentTitle = currentTitle;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public boolean getCurrentSchool() {
        return currentSchool;
    }

    public void setCurrentSchool(boolean currentSchool) {
        this.currentSchool = currentSchool;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        String seperator = "&";
        if (firstName != null) {
            builder.append("first-name=");
            builder.append(firstName);
            builder.append(seperator);
        }
        if (lastName != null) {
            builder.append("last-name=");
            builder.append(lastName);
            builder.append(seperator);
        }
        if (companyName != null) {
            builder.append("company-name=");
            builder.append(companyName);
            builder.append(seperator);
            if (currentCompany) {
                builder.append("currentCompany=");
                builder.append(currentCompany);
                builder.append(seperator);
            }
        }
        if (title != null) {
            builder.append("title=");
            builder.append(title);
            builder.append(seperator);
            if (currentTitle) {
                builder.append("current-title=");
                builder.append(currentTitle);
                builder.append(seperator);
            }
        }
        if (schoolName != null) {
            builder.append("school-name=");
            builder.append(schoolName);
            builder.append(seperator);
            if (currentSchool) {
                builder.append("current-school=");
                builder.append(currentSchool);
                builder.append(seperator);
            }
        }
        return builder.toString();
    }
}
