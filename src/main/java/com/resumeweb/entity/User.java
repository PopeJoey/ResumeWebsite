package com.resumeweb.entity;

import java.util.ArrayList;

public class User {
    int userId;
    String userAccount;
    String email;

    ArrayList<Resume> resumes;

    public ArrayList<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(ArrayList<Resume> resumes) {
        this.resumes = resumes;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
