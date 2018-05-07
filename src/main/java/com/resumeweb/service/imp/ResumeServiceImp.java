package com.resumeweb.service.imp;

import com.resumeweb.entity.Resume;
import com.resumeweb.service.ResumeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResumeServiceImp implements ResumeService{
    //
    public Map<Integer,String> getPatternList(){
        return new HashMap<Integer, String>();
    }

    @Override
    public List<Resume> getResumeList(int userId) {
        return null;
    }

}
