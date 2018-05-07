package com.resumeweb.springmvc.controller;

import com.resumeweb.entity.User;
import com.resumeweb.service.LogAndRegisterService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
        model.addAttribute("User",new User());
        return "register";
    }

    @RequestMapping("/toRegister")
    public String register(@Valid User user, BindingResult result, ModelMap model){
        if(result.hasErrors()) {
            return "register";
        }
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");

        LogAndRegisterService service = (LogAndRegisterService)context.getBean("LogAndRegisterService");
        if(service.register(user)){
            model.addAttribute("currentUser",service.getUserId(user.getUserAccount()));
            return "redirect:/homepage";
        }
        return "register";
    }
}
