package com.resumeweb.springmvc.controller;

import com.resumeweb.entity.UserSession;
import com.resumeweb.service.LogAndRegisterService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;

@SessionAttributes("currentUser")
@Controller
public class LoginCtrl {
    public static ApplicationContext context;
    static {
        context = (WebApplicationContext) ContextLoader.getCurrentWebApplicationContext();
    }

    @RequestMapping("/login")
    public String showLogin(ModelMap model){
        model.addAttribute("title","登录");
        return "login";
    }

    @RequestMapping(value = "/tologin",method = RequestMethod.POST)
    public String login(@Valid UserSession userSession, BindingResult result, ModelMap model){
        System.out.println(userSession.toString());
        if(result.hasErrors()) {
            return "login";
        }
        System.out.println(userSession.toString());

        LogAndRegisterService service = (LogAndRegisterService)context.getBean("logAndRegisterService");
        if(service.logIn(userSession.getUsername(),userSession.getPassword())){
            model.addAttribute("currentUser",service.getUserId(userSession.getUsername()));
            System.out.println(model.get("currentUser"));
            return "redirect:/homepage";
        }
        else {
            model.addAttribute("returnInfo","用户名或密码错误，请重试");
        }
        return "login";
    }
}
