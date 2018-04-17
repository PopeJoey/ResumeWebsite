package com.resumeweb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactCtrl {

    @RequestMapping("/contact")
    public String contact(Model model){
        model.addAttribute("title","联系我们");
        model.addAttribute("page_id",4);
        return "contact";
    }
}
