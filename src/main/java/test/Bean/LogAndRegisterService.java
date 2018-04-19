package main.java.test.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogAndRegisterService {
    private userDaoImp userDaoImp;
    @Autowired
    public void setUserDaoImp(userDaoImp userDaoImp){
        this.userDaoImp=userDaoImp;
    }
    public boolean register(user user){
        if (userDaoImp.existUser(user.getUser_account())){
            return false;
        }else {
            userDaoImp.addUser(user);
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
