package com.resumeweb.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.resumeweb.entity.*;
import com.resumeweb.service.ResumeService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class NewResumeCtrl {
    public static ApplicationContext context;
    static {
        context = (WebApplicationContext) ContextLoader.getCurrentWebApplicationContext();
    }
    String[] stepList = new String[]{"write","write_base","write_edu","write_proj"};

    //显示上一步
    @RequestMapping("/previousStep")
    public String previousStep(HttpSession session){
        Integer userid = (Integer) session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }
        Integer currentStep = (Integer)session.getAttribute("currentStep");
        if(currentStep == null || currentStep <= 0){
            return "redirect:/newResume";
        }else{
            session.setAttribute("currentStep",currentStep - 2);
            return "redirect:/newResume";
        }

    }

    //显示第一步
    @RequestMapping("/newResume")
    public String newResume(ModelMap model,HttpSession session){
        Integer userid = (Integer) session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }

        Resume resume = (Resume)session.getAttribute("currentResume");
        if(resume == null){
            resume = new Resume();
            resume.setUserId(userid);
            session.setAttribute("currentResume",resume);
            session.setAttribute("currentStep",0);
            return stepList[0];
        }
        System.out.println(resume.toString());
        int currentStep = (Integer)session.getAttribute("currentStep");
        switch (currentStep){
            case 0:
                return "forward:/newResumeInfo";
            case 1:
                return "forward:/newBaseInfo";
            case 2:
                return "forward:/newEduInfo";
            case 3:
                return "forward:/addNewResume";
        }
        return stepList[0];
    }

    //处理第一步并显示第二步（处理简历基本信息）
    @RequestMapping("/newResumeInfo")
    public String newBaseInfo(@Valid Resume inResume,
                              ModelMap model,
                              HttpSession session){
        Integer userid = (Integer)session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }
        Resume currentResume = (Resume)session.getAttribute("currentResume");
        if(currentResume == null){
            return "redirect:/newResume";
        }
        currentResume.setPatternId(inResume.getPatternId());
        currentResume.setResumeName(inResume.getResumeName());
        currentResume.setEducations(new ArrayList<EduInfo>());
        currentResume.setProjects(new ArrayList<ProjectInfo>());

        session.setAttribute("currentStep",1);
        return stepList[1];

    }

    //处理第二步并显示第三步（处理用户基本信息）
    @RequestMapping("/newBaseInfo")
    public String newEduInfo(@Valid BaseInfo inBaseInfo,
                             ModelMap model,
                             HttpSession session){
        Integer userid = (Integer)session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }
        Resume currentResume = (Resume)session.getAttribute("currentResume");
        if(currentResume == null){
            return "redirect:/newResume";
        }
        inBaseInfo.setUserId(userid);
        currentResume.setBaseInfo(inBaseInfo);
        session.setAttribute("currentStep",2);
        return stepList[2];
    }

    //显示第四步
    @RequestMapping("/newEduInfo")
    public String newEduInfo(HttpSession session){
        Integer userid = (Integer)session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }
        Resume currentResume = (Resume)session.getAttribute("currentResume");
        if(currentResume == null){
            return "redirect:/newResume";
        }
        session.setAttribute("currentStep",3);
        return stepList[3];
    }

    //处理第三步,Ajax交互
    //新建简历--简历教育信息
    @RequestMapping("/newEduInfoAjax")
    public @ResponseBody String addEduInfo(@Valid EduInfo eduInfo,
                                           BindingResult result,
                                           HttpSession session){
        Integer userid = (Integer) session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }
        if(result.hasErrors()) {
            return result.toString();
        }
        Resume currentResume = (Resume)session.getAttribute("currentResume");
        if(currentResume == null){
            session.setAttribute("currentStep",0);
            return "";
        }
        ArrayList<EduInfo> eduInfos = currentResume.getEducations();
        eduInfo.setUserId(userid);
        eduInfos.add(eduInfo);
        return "{'succeed':1}";
    }

    //处理第四步,Ajax交互
    //新建简历--简历项目信息
    @RequestMapping("/newProjectInfoAjax")
    public @ResponseBody String addProjectInfo(@Valid ProjectInfo projectInfo,
                                           BindingResult result,
                                           HttpSession session){
        Integer userid = (Integer) session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }
        if(result.hasErrors()) {
            return result.toString();
        }
        Resume currentResume = (Resume)session.getAttribute("currentResume");
        if(currentResume == null){
            session.setAttribute("currentStep",0);
            return "";
        }
        ArrayList<ProjectInfo> projectInfos = currentResume.getProjects();
        projectInfo.setUserId(userid);
        projectInfos.add( projectInfo);
        return "{'succeed':1}";
    }


    //新建简历--保存简历
    @RequestMapping("/addNewResume")
    public String addNewResume(HttpSession session){
        Integer userid = (Integer) session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }
        Resume resume = (Resume)session.getAttribute("currentResume");
        ResumeService service = (ResumeService)context.getBean("resumeService");
        service.addNewResume(resume);
        session.removeAttribute("currentResume");
        return "redirect:/my";
    }

    /**
     * 简历模板列表
     * @return
     */
    @ModelAttribute("patternList")
    public Map<Integer,String> getPatternList(){
        ResumeService service = (ResumeService)context.getBean("resumeService");
        Map<Integer,String> patternMap = service.getPatternMap();
        return patternMap;
    }

}
