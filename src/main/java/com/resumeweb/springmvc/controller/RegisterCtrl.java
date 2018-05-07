package com.resumeweb.springmvc.controller;

import com.resumeweb.entity.User;
import com.resumeweb.service.LogAndRegisterService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.validation.Valid;

@SessionAttributes("currentUser")
@Controller
public class RegisterCtrl {
    public static ApplicationContext context;
    static {
        context = (WebApplicationContext) ContextLoader.getCurrentWebApplicationContext();
    }

    @RequestMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("title","注册");
        model.addAttribute("User",new User());
        return "register";
    }

    @RequestMapping("/toRegister")
    public String register(@Valid User user, BindingResult result, ModelMap model){
        if(result.hasErrors()) {
            return "register";
        }
        LogAndRegisterService service = (LogAndRegisterService)context.getBean("logAndRegisterService");
        if(service.register(user)){
            model.addAttribute("currentUser",service.getUserId(user.getUserAccount()));
            return "redirect:/homepage";
        }
        return "register";
    }
}
