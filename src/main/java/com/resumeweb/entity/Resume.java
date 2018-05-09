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
        String eduStr = "[";
        if(educations != null && educations.size() > 0) {
            for (EduInfo info : educations) {
                eduStr += info.toString();
                eduStr += ", ";
            }
            eduStr = eduStr.substring(0, eduStr.length() - 2);
        }
        eduStr += "]";

        String projectStr = "[";
        if(projects != null && projects.size() > 0) {
            for (ProjectInfo info : projects) {
                projectStr += info.toString();
                projectStr += ", ";
            }
            projectStr = projectStr.substring(0, projectStr.length() - 2);
        }
        projectStr += "]";

        return "{'resumeId':" + resumeId + ", 'resumeName':" + resumeName
                +     ", 'userId':" + userId + ", 'patternId':" + patternId
                +     ", 'baseInfo':" + (baseInfo==null?null:baseInfo.toString())
                +     ", 'educations':" + eduStr + ", 'projects':" + projectStr
                +     "}";
    }
}
