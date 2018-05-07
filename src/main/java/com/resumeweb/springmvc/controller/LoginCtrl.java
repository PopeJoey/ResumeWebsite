package com.resumeweb.springmvc.controller;

import com.resumeweb.entity.UserSession;
import com.resumeweb.service.LogAndRegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@SessionAttributes("currentUser")
@Controller
public class LoginCtrl {

    @RequestMapping("/login")
    public String showLogin(ModelMap model){
        model.addAttribute("title","登录");
        model.addAttribute("UserSession",new UserSession());
        return "login";
    }

    @RequestMapping(value = "/tologin",method = RequestMethod.POST)
    public String login(@Valid UserSession userSession, BindingResult result, ModelMap model){
        if(result.hasErrors()) {
            return "login";
        }
        LogAndRegisterService service = new LogAndRegisterService();
        if(service.logIn(userSession.getUsername(),userSession.getPassword())){
            model.addAttribute("currentUser",service.getUserId(userSession.getUsername()));
            return "redirect:/homepage";
        }
        return "login";
    }
}
