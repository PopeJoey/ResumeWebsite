package com.resumeweb.entity;

import java.util.ArrayList;

public class Resume {
    private int resumeId;
    private String resumeName;
    private int userId;

    private int patternId;
    private BaseInfo baseInfo;
    private ArrayList<EduInfo> educations;
    private ArrayList<ProjectInfo> projects;

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public String getResumeName() {
        return resumeName;
    }

    public void setResumeName(String resumeName) {
        this.resumeName = resumeName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    public ArrayList<EduInfo> getEducations() {
        return educations;
    }

    public void setEducations(ArrayList<EduInfo> educations) {
        this.educations = educations;
    }

    public ArrayList<ProjectInfo> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<ProjectInfo> projects) {
        this.projects = projects;
    }

    public int getPatternId() {
        return patternId;
    }

    public void setPatternId(int patternId) {
        this.patternId = patternId;
    }

    @Override
    public String toString(){
        return "{'resumeId':" + resumeId + ", 'resumeName':" + resumeName
                +     ", 'userId':" + userId + ", 'patternId':" + patternId
                +     ", 'baseInfo':" + (baseInfo==null?null:baseInfo.toString())
                +     "}";
    }
}
