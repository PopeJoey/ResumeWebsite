package com.resumeweb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyResumeCtrl {
    @RequestMapping("/my")
    public String myResume(Model model){
        model.addAttribute("title","我的简历");
        model.addAttribute("page_id",3);
        return "myresume";
    }
}
