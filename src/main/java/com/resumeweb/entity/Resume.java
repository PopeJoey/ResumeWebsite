package com.resumeweb.entity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Resume {
    int resumeId;
    String resumeName;
    int userId;

    int patternId;
    BaseInfo baseInfo;
    ArrayList<EduInfo> educations;
    ArrayList<ProjectInfo> projects;

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
}
