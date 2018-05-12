package com.resumeweb.springmvc.controller;

import com.resumeweb.entity.Pattern;
import com.resumeweb.entity.Resume;
import com.resumeweb.service.ResumeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpSession;

@Controller
public class PreviewCtrl {
    static WebApplicationContext context =
            ContextLoader.getCurrentWebApplicationContext();

    @RequestMapping("/previewResume/{resumeId}")
    public String previewResume(@PathVariable("resumeId")int resumeId,
                                HttpSession session,
                                ModelMap model){
        Integer uid = (Integer)session.getAttribute("currentUser");
        if(uid == null || uid <= 0){
            return "redirect:/login";
        }

        ResumeService service = (ResumeService)context.getBean("resumeService");
        Resume resume = service.getResumeByRid(resumeId);
        if(resume != null){
            model.addAttribute("currentResume",resume);
        }
        //Pattern pattern = service.getPattern(resume.getPatternId());
        return "pattern01";//pattern.getPatternPath();
    }
}
