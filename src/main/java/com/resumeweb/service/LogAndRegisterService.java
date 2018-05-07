package com.resumeweb.service;

import com.resumeweb.DAO.UserDao;
import com.resumeweb.entity.User;

public interface LogAndRegisterService {
    public void setUserDao(UserDao userDao);
    public boolean register(User user);
    public boolean logIn(String account,String password);
    public int getUserId(String account);

}
