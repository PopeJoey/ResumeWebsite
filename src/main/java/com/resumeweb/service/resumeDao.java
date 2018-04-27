package com.resumeweb.service;

import com.resumeweb.entity.Resume;

public interface resumeDao {
    void addResume(Resume resume);
    void deleteResume(Resume resume);
    void updateResume(Resume resume);
    void getResume(Resume resume);
}
