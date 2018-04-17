package com.resumeweb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutCtrl {

    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title","关于我们");
        model.addAttribute("page_id",3);
        return "about";
    }
}
