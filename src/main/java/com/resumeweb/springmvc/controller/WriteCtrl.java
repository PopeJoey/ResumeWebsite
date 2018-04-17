package com.resumeweb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WriteCtrl {

    @RequestMapping("/write")
    public String write(Model model){
        model.addAttribute("title","填写信息");
        return "write";
    }
}
