package com.resumeweb.service.imp;

import com.resumeweb.DAO.UserDao;
import com.resumeweb.entity.User;
import com.resumeweb.service.LogAndRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogAndRegisterServiceImp implements LogAndRegisterService{
    private UserDao userDao;
    @Autowired
    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    public boolean register(User user){
        if (userDao.existUser(user.getUserAccount())){
            return false;
        }else {
            userDao.addUser(user);
            return true;
        }
    }
    public boolean logIn(String account,String password){
        if (userDao.existUser(account)&& userDao.getPassword(account).equals(password)){
            return true;
        }
        return false;
    }

    public int getUserId(String account){
        return userDao.getUserId(account);
    }

}
