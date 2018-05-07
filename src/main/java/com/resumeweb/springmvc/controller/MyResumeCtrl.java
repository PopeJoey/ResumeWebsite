package com.resumeweb.springmvc.controller;

import com.resumeweb.entity.Resume;
import com.resumeweb.service.ResumeService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyResumeCtrl {
    public static ApplicationContext context;
    static {
        context = (WebApplicationContext) ContextLoader.getCurrentWebApplicationContext();
    }

    @RequestMapping("/my")
    public String myResume(Model model, HttpSession session){
        Integer currentUserId = (Integer) session.getAttribute("currentUser");
        if(currentUserId != null && currentUserId > 0){
            model.addAttribute("title","我的简历");
            model.addAttribute("page_id",3);
            ResumeService service = (ResumeService)context.getBean("resumeService");
            List<Resume> resumeList = service.getResumeList(currentUserId);
            model.addAttribute("ResumeList",resumeList);
            return "myresume";
        }

        return "login";
    }
}
