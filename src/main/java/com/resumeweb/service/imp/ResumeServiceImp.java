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

    /**
     * 通过pid获取pattern
     *
     * @param pid
     * @return
     */
    @Override
    public Pattern getPattern(int pid) {
        WebApplicationContext context =
                ContextLoader.getCurrentWebApplicationContext();
        PatternDao patternDao = (PatternDao)context.getBean("patternDao");
        return patternDao.getPattern(pid);
    }

    @Override
    public List<Resume> getResumeList(int userId) {
        WebApplicationContext context =
                ContextLoader.getCurrentWebApplicationContext();
        ResumeDao resumeDao = (ResumeDao)context.getBean("resumeDao");
        List<Resume> resumes = resumeDao.getAllResumes(userId);
        return resumes;

    }

    /**
     * 通过resumeId获取resume
     *
     * @param resumeId
     * @return
     */
    @Override
    public Resume getResumeByRid(int resumeId) {
        WebApplicationContext context =
                ContextLoader.getCurrentWebApplicationContext();
        ResumeDao resumeDao = (ResumeDao)context.getBean("resumeDao");
        return resumeDao.getResume(resumeId);
    }

    /**
     * 保存简历
     * @param resume 简历对象
     */
    @Override
    public void saveResume(Resume resume) {
        WebApplicationContext context =
                ContextLoader.getCurrentWebApplicationContext();
        ResumeDao resumeDao = (ResumeDao)context.getBean("resumeDao");
        if(resume.getResumeId() > 0){
            resumeDao.updateResume(resume);
        }else {
            int rid = resumeDao.addResume(resume);
            resume.setResumeId(rid);
        }

        if(resume.getEducations().size() > 0){
            ResumeEdusDao resumeEdusDao = (ResumeEdusDao) context.getBean("resumeEdusDao");
            for(EduInfo info:resume.getEducations()){
                try {
                    resumeEdusDao.addResumeEdus(resume.getResumeId(), info.getEduInfoId());
                }catch (Exception e){}
            }
        }

        if(resume.getProjects().size() > 0){
            ResumeProjectsDao resumeProjectsDao = (ResumeProjectsDao)context.getBean("resumeProjectsDao");
            for(ProjectInfo info:resume.getProjects()){
                try {
                    resumeProjectsDao.addResume_projects(resume.getResumeId(), info.getProjectInfoId());
                }catch (Exception e){}
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
        System.out.println(baseInfo);
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
        List<EduInfo> eduInfos = resume.getEducations();
        if(index < eduInfos.size()){
            WebApplicationContext context =
                    ContextLoader.getCurrentWebApplicationContext();
            EduInfoDao eduInfoDao = (EduInfoDao)context.getBean("eduInfoDao");
            EduInfo info = eduInfos.get(index);
            if(info.getEduInfoId() > 0){
                eduInfoDao.updateEduInfo(info);
            }else{
                int eid = eduInfoDao.addEduInfo(info);
                info.setEduInfoId(eid);
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
        List<EduInfo> eduInfos = resume.getEducations();
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
        List<ProjectInfo> projectInfos = resume.getProjects();

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
        List<ProjectInfo> projectInfos = resume.getProjects();

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
