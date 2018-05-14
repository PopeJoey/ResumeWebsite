package com.resumeweb.springmvc.controller;

import com.resumeweb.entity.Resume;
import com.resumeweb.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ModifyResumeCtrl {
    static WebApplicationContext context =
            ContextLoader.getCurrentWebApplicationContext();

    @RequestMapping("/modifyResume/{resumeId}")
    public String modifyResume(@PathVariable("resumeId")int resumeId,
                               HttpSession session){
        Integer uid = (Integer)session.getAttribute("currentUser");
        if(uid == null || uid <= 0){
            return "redirect:/login";
        }

        ResumeService service = (ResumeService)context.getBean("resumeService");
        Resume resume = service.getResumeByRid(resumeId);
        if(resume != null){
            session.setAttribute("currentResume",resume);
        }
        session.setAttribute("currentStep",0);
        return "forward:/newResume";
    }

    @RequestMapping("/modifyResume/**/**")
    public String staticResource(HttpServletRequest request){
        String url = request.getRequestURI().toString();
        return "redirect:" + url.substring(13,url.length());
    }
}
