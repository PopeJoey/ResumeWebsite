package com.resumeweb.service;

import com.resumeweb.entity.EduInfo;
import com.resumeweb.entity.ProjectInfo;
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
     * 获取用户简历列表
     * @param userId 用户id
     * @return List<Resume>简历列表
     */
    public List<Resume> getResumeList(int userId);

    /**
     * 增加新的简历
     * @param resume 简历对象
     */
    public void addNewResume(Resume resume);

    /**
     * 保存教育信息到数据库，并填充教育信息id
     * @param eduInfo 教育信息
     */
    public void addNewEduInfo(EduInfo eduInfo);

    /**
     * 保存项目信息到数据库，并填充项目信息id
     * @param projectInfo
     */
    public void addNewProjectInfo(ProjectInfo projectInfo);

}
