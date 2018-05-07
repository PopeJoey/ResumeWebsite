package com.resumeweb.service;

import com.resumeweb.DAO.userDaoImp;
import com.resumeweb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.resumeweb.DAO.userDao;

@Service
public class LogAndRegisterService {
    private userDao userDao;
    @Autowired
    public void setUserDao(userDao userDao){
        this.userDao=userDao;
    }
    public boolean register(User User){
        if (userDao.existUser(User.getUserAccount())){
            return false;
        }else {
            userDao.addUser(User);
            return true;
        }
    }
    public boolean logIn(String account,String password){
        if (userDao.existUser(account)&&userDao.getPassword(account).equals(password)){
           return true;
        }
        return false;
    }

    public int getUserId(String account){
        return userDao.getUserId(account);
    }

}
