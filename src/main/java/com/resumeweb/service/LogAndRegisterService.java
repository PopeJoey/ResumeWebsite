package com.resumeweb.service;

import com.resumeweb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogAndRegisterService {
    private userDaoImp userDaoImp;
    @Autowired
    public void setUserDaoImp(userDaoImp userDaoImp){
        this.userDaoImp=userDaoImp;
    }
    public boolean register(User User){
        if (userDaoImp.existUser(User.getUserAccount())){
            return false;
        }else {
            userDaoImp.addUser(User);
            return true;
        }
    }
    public boolean logIn(String account,String password){
        if (userDaoImp.existUser(account)&&userDaoImp.getPassword(account).equals(password)){
           return true;
        }
        return false;
    }

}
