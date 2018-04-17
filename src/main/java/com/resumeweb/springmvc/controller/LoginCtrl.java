package com.resumeweb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginCtrl {

    @RequestMapping("/login")
    public String showLogin(Model model){

        return "login";
    }
}
