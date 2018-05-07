package com.resumeweb.entity;

import java.sql.Date;

public class EduInfo {
    private int eduInfoId;
    private int userId;
    private Date startDate;
    private Date endDate;
    private String school;
    private String major;
    private String edu;
    private String rank;

    public int getEduInfoId() {
        return eduInfoId;
    }

    public void setEduInfoId(int eduInfoId) {
        this.eduInfoId = eduInfoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
