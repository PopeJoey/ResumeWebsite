package com.resumeweb.service;

import com.resumeweb.entity.Pattern;
import com.resumeweb.entity.Resume;

import java.util.List;
import java.util.Map;

public interface ResumeService {
    /**
     * 获取模板id-名称map
     * @return Map<Integer,String> Integer：模板id, String：模板名称
     */
    public Map<Integer,String> getPatternMap();

    /**
     * 通过pid获取pattern
     * @param pid
     * @return
     */
    public Pattern getPattern(int pid);

    /**
     * 获取用户简历列表
     * @param userId 用户id
     * @return List<Resume>简历列表
     */
    public List<Resume> getResumeList(int userId);

    /**
     * 通过resumeId获取resume
     * @param resumeId
     * @return
     */
    public Resume getResumeByRid(int resumeId);
    /**
     * 增加新的简历
     * @param resume 简历对象
     */
    public void saveResume(Resume resume);

    /**
     * 将基础信息保存至数据库
     * @param resume
     */
    public void inBaseInfo(Resume resume);

    /**
     * 将教育信息保存至数据库
     * @param Resume
     */
    public void inEduInfo(Resume resume,int index);

    /**
     * 删除教育信息
     * @param eduInfo
     */
    public void deleteEduInfo(Resume resume,int index);

    /**
     * 将项目信息保存至数据库
     * @param resume
     */
    public void inProjectInfo(Resume resume,int index);

    /**
     * 删除项目信息
     * @param projectInfo
     */
    public void deleteProjectInfo(Resume resume,int index);

}
