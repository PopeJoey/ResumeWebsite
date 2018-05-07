package com.resumeweb.service;

import com.resumeweb.entity.Resume;

import java.util.List;
import java.util.Map;

public interface ResumeService {
    /**
     * 获取模板列表
     * @return Map<Integer,String> Integer：模板id, String：模板名称
     */
    public Map<Integer,String> getPatternList();

    /**
     * 获取用户简历列表
     * @param userId 用户id
     * @return List<Resume>简历列表
     */
    public List<Resume> getResumeList(int userId);

}
