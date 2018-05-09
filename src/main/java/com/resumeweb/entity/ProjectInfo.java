package com.resumeweb.entity;

import java.sql.Date;

public class ProjectInfo {
    private int projectInfoId;
    private int userId;
    private String proOrIntern;
    private String projectName;
    private Date startDate;
    private Date endDate;

    private String description;

    public int getProjectInfoId() {
        return projectInfoId;
    }

    public void setProjectInfoId(int projectInfoId) {
        this.projectInfoId = projectInfoId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProOrIntern() {
        return proOrIntern;
    }

    public void setProOrIntern(String proOrIntern) {
        this.proOrIntern = proOrIntern;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"projectInfoId\":")
                .append(projectInfoId);
        sb.append(",\"userId\":")
                .append(userId);
        sb.append(",\"proOrIntern\":\"")
                .append(proOrIntern).append('\"');
        sb.append(",\"projectName\":\"")
                .append(projectName).append('\"');
        sb.append(",\"startDate\":\"")
                .append(startDate).append('\"');
        sb.append(",\"endDate\":\"")
                .append(endDate).append('\"');
        sb.append(",\"description\":\"")
                .append(description).append('\"');
        sb.append('}');
        return sb.toString();
    }

}
