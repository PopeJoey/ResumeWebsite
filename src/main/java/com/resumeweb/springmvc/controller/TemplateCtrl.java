package com.resumeweb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateCtrl {

    @RequestMapping("/template")
    public String template(Model model){

        return "template";
    }

}
