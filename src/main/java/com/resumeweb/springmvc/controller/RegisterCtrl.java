package com.resumeweb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterCtrl {

    @RequestMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("title","注册");
        return "register";
    }
}
