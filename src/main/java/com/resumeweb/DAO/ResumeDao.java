package com.resumeweb.DAO;

import com.resumeweb.entity.Resume;

public interface ResumeDao {
    void addResume(Resume resume);
    void deleteResume(Resume resume);
    void updateResume(Resume resume);
    void getResume(Resume resume);
}
