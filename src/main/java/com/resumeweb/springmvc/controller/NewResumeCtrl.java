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

    //显示页面
    @RequestMapping("/new")
    public String newResume(ModelMap model,HttpSession session){
        Resume resume = new Resume();
        resume.setUserId((Integer)session.getAttribute("currentUser"));
        session.setAttribute("currentResume",resume);
        return "redirect:/new/step/0";
    }

    //显示页面
    @RequestMapping({"/new/step/{stepCount}","/new/step/{stepCount}/**"})
    public String showContent(Model model,
                             HttpServletRequest request,
                             @PathVariable("stepCount") String step){
        HttpSession session = request.getSession();
        Integer userid = (Integer) session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }
        try{
            int stepCount = Integer.parseInt(step);
            model.addAttribute("title","新建简历");
            model.addAttribute("page_id","3");
            Resume currentResume = (Resume)session.getAttribute("currentResume");
            System.out.println(currentResume.toString());
            return stepList[stepCount];
        }catch (NumberFormatException e){
            return redirectRoot(request);
        }
    }

    //新建简历-简历基本信息
    @RequestMapping("/addResume/0")
    public String addResumeInfo(@Valid Resume currentResume,
                            BindingResult result,
                            ModelMap model,
                            HttpSession session){
        Integer userid = (Integer) session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }
        if(result.hasErrors()) {
            return "redirect:/new/step/0";
        }
        currentResume.setProjects(new ArrayList<ProjectInfo>());
        currentResume.setEducations(new ArrayList<EduInfo>());
        currentResume.setUserId(userid);
        session.setAttribute("currentResume",currentResume);

        return "redirect:/new/step/1";
    }

    //新建简历--简历个人信息
    @RequestMapping("/addResume/1")
    public String addBaseInfo(@Valid BaseInfo baseInfo,
                                BindingResult result,
                                ModelMap model,
                                HttpSession session){
        Integer userid = (Integer) session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }
        if(result.hasErrors()) {
            return "redirect:/new/step/1";
        }
        Resume currentResume = (Resume)session.getAttribute("currentResume");
        if(currentResume == null){
            return "redirect:/new/step/0";
        }
        baseInfo.setUserId(userid);
        currentResume.setBaseInfo(baseInfo);
        return "redirect:/new/step/2";
    }

    //新建简历--简历教育信息
    @RequestMapping("/addResume/2")
    public @ResponseBody String addEduInfo(@Valid EduInfo eduInfo,
                                           BindingResult result,
                                           HttpSession session){
        Integer userid = (Integer) session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }
        if(result.hasErrors()) {
            return "redirect:/" + stepList[1];
        }
        Resume currentResume = (Resume)session.getAttribute("currentResume");
        if(currentResume == null){
            return "redirect:/" + stepList[0];
        }
        ArrayList<EduInfo> eduInfos = currentResume.getEducations();
        eduInfos.add(eduInfo);
        return "succeed";
    }

    //新建简历--简历项目信息
    @RequestMapping(value = "/addResume/3", method = RequestMethod.POST)
    public @ResponseBody String addProjectInfo(@Valid ProjectInfo projectInfo,
                                           BindingResult result,
                                           ModelMap model,
                                           HttpSession session){
        Integer userid = (Integer) session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }
        if(result.hasErrors()) {
            return "redirect:/new/step/3";
        }
        Resume currentResume = (Resume)session.getAttribute("currentResume");
        if(currentResume == null){
            return "redirect:/new/step/0";
        }
        ArrayList<ProjectInfo> projectInfos = currentResume.getProjects();
        projectInfos.add(projectInfo);
        return "succeed";
    }

    //新建简历--保存简历
    @RequestMapping(value = "/addResume/complete", method = RequestMethod.GET)
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
     * 重定向到项目的根目录
     * @param request
     * @return redirect path
     */
    public String redirectRoot(HttpServletRequest request){
        String fullPath = request.getRequestURI();
        String subPath = fullPath.substring(fullPath.indexOf("step") + 5);

        return "redirect:/" + subPath;
    }

    /**
     * 简历模板列表
     * @return
     */
    @ModelAttribute("patternList")
    public Map<Integer,String> getPatternList(){
        ResumeService service = (ResumeService)context.getBean("resumeService");
        Map<Integer,String> patternMap = service.getPatternList();
        return patternMap;
    }

}
