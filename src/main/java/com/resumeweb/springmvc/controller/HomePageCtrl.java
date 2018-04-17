package com.resumeweb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageCtrl {
    @RequestMapping({"/homepage","/"})
    public String homepage(Model model){
        model.addAttribute("title","主页");
        model.addAttribute("page_id",1);
        return "index";
    }
}
