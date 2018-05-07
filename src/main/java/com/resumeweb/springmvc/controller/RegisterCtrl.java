package com.resumeweb.springmvc.controller;

import com.resumeweb.entity.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RegisterCtrl {

    @RequestMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("title","注册");
        return "register";
    }

    @RequestMapping("/toRegister")
    public String register(@Valid UserSession userSession, BindingResult result, ModelMap model){

    }
}
