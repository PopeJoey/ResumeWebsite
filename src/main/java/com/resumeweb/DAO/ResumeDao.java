package com.resumeweb.DAO;

import com.resumeweb.entity.Resume;

import java.util.ArrayList;

public interface ResumeDao {
    int addResume(Resume resume);
    void deleteResume(Resume resume);
    void updateResume(Resume resume);
    Resume getResume(int resume_id); //根据resume_id返回一个Resume实体
    ArrayList<Resume> getAllResumes(int user_id);//根据user_id返回该用户的所有resume

}
