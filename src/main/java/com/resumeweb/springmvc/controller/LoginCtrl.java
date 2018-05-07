package com.resumeweb.springmvc.controller;

import com.resumeweb.entity.UserSession;
import com.resumeweb.service.LogAndRegisterService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LoginCtrl {

    @RequestMapping("/login")
    public String showLogin(ModelMap model){
        model.addAttribute("title","登录");
        model.addAttribute("UserSession",new UserSession());
        return "login";
    }

    @RequestMapping(value = "/tologin",method = RequestMethod.POST)
    public String login(@Valid UserSession userSession, BindingResult result, ModelMap model, HttpServletRequest request){
        if(result.hasErrors()) {
            return "login";
        }
        LogAndRegisterService service = new LogAndRegisterService();
        if(service.logIn(userSession.getUsername(),userSession.getPassword())){
            model.addAttribute("UserSession",userSession);
            request.getSession().setAttribute("currentUser",userSession);
            return "redirect:/homepage";
        }
        return "login";
    }

    @
}
