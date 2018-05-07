package com.resumeweb.entity;

import javax.validation.constraints.Size;
import java.io.Serializable;

//session中保存用户状态的类
public class UserSession implements Serializable {
    @Size(min = 3,max = 20)
    private String username;

    @Size(min = 3,max = 20)
    private String password;

    public UserSession(){}

    public UserSession(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "UserSession [" + "username=" + username + ", password=" + password
                         + "]";
    }
}
