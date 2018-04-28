package com.resumeweb.springmvc.controller;

import com.resumeweb.entity.UserSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginCtrl {

    @RequestMapping("/login")
    public String showLogin(ModelMap model){
        model.addAttribute("title","登录");
        UserSession userSession = new UserSession();
        model.addAttribute("UserSession",userSession);
        return "login";
    }

    @RequestMapping(value = "/tologin",method = RequestMethod.POST)
    public String login(@Valid UserSession userSession, BindingResult result, ModelMap model){
        if(result.hasErrors()){
            return "login";
        }
        model.addAttribute("UserSession",userSession);
        return "redirect:/homepage";
    }
}
