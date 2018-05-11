package com.resumeweb.service.imp;

import com.resumeweb.DAO.*;
import com.resumeweb.entity.*;
import com.resumeweb.service.ResumeService;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

public class ResumeServiceImp implements ResumeService{
    //
    public Map<Integer,String> getPatternMap(){
        WebApplicationContext context =
                ContextLoader.getCurrentWebApplicationContext();
        PatternDao patternDao = (PatternDao)context.getBean("patternDao");
        List<Pattern> patterns = patternDao.getPatternList();
        Map<Integer,String> result = new HashMap<Integer, String>();
        for(Pattern pattern:patterns){
            result.put(pattern.getPatternId(),pattern.getPatternName());
        }
        return result;
    }

    @Override
    public List<Resume> getResumeList(int userId) {
        return null;
    }

    /**
     * 增加新的简历
     * @param resume 简历对象
     */
    @Override
    public void addNewResume(Resume resume) {
        WebApplicationContext context =
                ContextLoader.getCurrentWebApplicationContext();
        ResumeDao resumeDao = (ResumeDao)context.getBean("resumeDao");
        int rid = resumeDao.addResume(resume);
        resume.setResumeId(rid);

        if(resume.getEducations().size() > 0){
            ResumeEdusDao resumeEdusDao = (ResumeEdusDao) context.getBean("resumeEdusDao");
            for(EduInfo info:resume.getEducations()){
                resumeEdusDao.addResumeEdus(rid,info.getEduInfoId());
            }
        }

        if(resume.getProjects().size() > 0){
            ResumeProjectsDao resumeProjectsDao = (ResumeProjectsDao)context.getBean("resumeProjectsDao");
            for(ProjectInfo info:resume.getProjects()){
                resumeProjectsDao.addResume_projects(rid,info.getProjectInfoId());
            }
        }
    }

    /**
     * 将基础信息保存至数据库
     *
     * @param resume
     */
    @Override
    public void inBaseInfo(Resume resume) {
        BaseInfo baseInfo = resume.getBaseInfo();
        WebApplicationContext context =
                ContextLoader.getCurrentWebApplicationContext();
        BaseInfoDao baseInfoDao = (BaseInfoDao)context.getBean("baseInfoDao");
        if(baseInfo.getBaseInfoId() > 0){
            baseInfoDao.updateBaseInfo(baseInfo);
        }else{
            int bid = baseInfoDao.addBaseInfo(baseInfo);
            baseInfo.setBaseInfoId(bid);
        }
    }

    /**
     * 将教育信息保存至数据库
     *
     * @param resume
     */
    @Override
    public void inEduInfo(Resume resume,int index) {
        ArrayList<EduInfo> eduInfos = resume.getEducations();
        if(index < eduInfos.size()){
            WebApplicationContext context =
                    ContextLoader.getCurrentWebApplicationContext();
            EduInfoDao eduInfoDao = (EduInfoDao)context.getBean("eduInfoDao");
            EduInfo info = eduInfos.get(index);
            if(info.getEduInfoId() > 0){
                eduInfoDao.updateEduInfo(info);
            }else{
                eduInfoDao.addEduInfo(info);
            }
        }else{
            throw new IndexOutOfBoundsException("index > list size");
        }

    }

    /**
     * 删除教育信息
     *
     * @param resume
     */
    @Override
    public void deleteEduInfo(Resume resume,int index) {
        ArrayList<EduInfo> eduInfos = resume.getEducations();
        if(index < eduInfos.size()){
            WebApplicationContext context =
                    ContextLoader.getCurrentWebApplicationContext();
            EduInfoDao eduInfoDao = (EduInfoDao)context.getBean("eduInfoDao");
            EduInfo info = eduInfos.remove(index);
            if(info.getEduInfoId() > 0){
                eduInfoDao.deleteEduInfo(info);
            }
            resume.setEducations(eduInfos);
        }else{
            throw new IndexOutOfBoundsException("index > list size");
        }
    }

    /**
     * 将项目信息保存至数据库
     *
     * @param resume
     */
    @Override
    public void inProjectInfo(Resume resume,int index) {
        ArrayList<ProjectInfo> projectInfos = resume.getProjects();

        if(index < projectInfos.size()){
            WebApplicationContext context =
                    ContextLoader.getCurrentWebApplicationContext();
            ProjectInfoDao projectInfoDao = (ProjectInfoDao)context.getBean("projectInfoDao");
            ProjectInfo projectInfo = projectInfos.get(index);
            if(projectInfo.getProjectInfoId() > 0){
                projectInfoDao.updateProjectInfo(projectInfo);
            }else{
                int pid = projectInfoDao.addProjectInfo(projectInfo);
                projectInfo.setProjectInfoId(pid);
            }
        }else{
            throw new IndexOutOfBoundsException("index > list size");
        }
    }

    /**
     * 删除项目信息
     *
     * @param resume
     */
    @Override
    public void deleteProjectInfo(Resume resume,int index) {
        ArrayList<ProjectInfo> projectInfos = resume.getProjects();

        if(index < projectInfos.size()){
            WebApplicationContext context =
                    ContextLoader.getCurrentWebApplicationContext();
            ProjectInfoDao projectInfoDao = (ProjectInfoDao)context.getBean("projectInfoDao");
            ProjectInfo projectInfo = projectInfos.remove(index);
            if(projectInfo.getProjectInfoId() > 0){
                projectInfoDao.deleteProjectInfo(projectInfo);
            }
            resume.setProjects(projectInfos);
        }else{
            throw new IndexOutOfBoundsException("index > list size");
        }
    }

}
