package com.resumeweb.service.imp;

import com.resumeweb.DAO.EduInfoDao;
import com.resumeweb.DAO.PatternDao;
import com.resumeweb.DAO.ProjectInfoDao;
import com.resumeweb.DAO.ResumeDao;
import com.resumeweb.entity.EduInfo;
import com.resumeweb.entity.Pattern;
import com.resumeweb.entity.ProjectInfo;
import com.resumeweb.entity.Resume;
import com.resumeweb.service.ResumeService;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public void addNewResume(Resume resume) {
        WebApplicationContext context =
                ContextLoader.getCurrentWebApplicationContext();
        ResumeDao resumeDao = (ResumeDao)context.getBean("resumeDao");
        resumeDao.addResume(resume);
    }

    @Override
    public void addNewEduInfo(EduInfo eduInfo) {
        WebApplicationContext context =
                ContextLoader.getCurrentWebApplicationContext();
        EduInfoDao eduInfoDao = (EduInfoDao)context.getBean("eduInfoDao");
        eduInfoDao.addEduInfo(eduInfo);
    }

    @Override
    public void addNewProjectInfo(ProjectInfo projectInfo) {
        WebApplicationContext context =
                ContextLoader.getCurrentWebApplicationContext();
        ProjectInfoDao projectInfoDao = (ProjectInfoDao)context.getBean("projectInfoDao");
        projectInfoDao.addProjectInfo(projectInfo);
    }

}
