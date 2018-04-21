package com.resumeweb.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NewResumeCtrl {
    @RequestMapping("/new")
    public String newResume(Model model){
        return "redirect:/new/step/1";
    }

    @RequestMapping("/new/step/{stepCount}")
    public String addContent(Model model, @PathVariable("stepCount") int stepCount){
        model.addAttribute("title","新建简历");
        model.addAttribute("page_id","3");
        switch (stepCount){
            case 1:
                return "write_base";
            case 2:
                return "write_edu";
            case 3:
                return "write_proj";
        }
        return "";
    }

    @RequestMapping("/new/step/{resourcesType}/**")
    public String getStaticResources(@PathVariable("resourcesType") String type){
        return "redirect:/" + type + "/**";
    }
}
