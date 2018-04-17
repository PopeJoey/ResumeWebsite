package com.resumeweb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateCtrl {

    @RequestMapping("/template")
    public String template(Model model){
        model.addAttribute("title","模板列表");
        model.addAttribute("page_id",2);
        return "template";
    }

}
