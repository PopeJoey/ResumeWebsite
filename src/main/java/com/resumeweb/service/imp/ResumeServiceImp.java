package com.resumeweb.service.imp;

import com.resumeweb.DAO.ResumeDao;
import com.resumeweb.entity.Resume;
import com.resumeweb.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;

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
        return new HashMap<Integer, String>();
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
