package com.resumeweb.service.imp;

import com.resumeweb.DAO.PatternDao;
import com.resumeweb.DAO.ResumeDao;
import com.resumeweb.entity.Pattern;
import com.resumeweb.entity.Resume;
import com.resumeweb.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumeServiceImp implements ResumeService{
    ResumeDao resumeDao;
    @Autowired
    public void setResumeDao(ResumeDao resumeDao){
        this.resumeDao = resumeDao;
    }
    //
    public Map<Integer,String> getPatternList(){
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
        resumeDao.addResume(resume);
    }

}
