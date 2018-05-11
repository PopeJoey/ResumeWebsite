package com.resumeweb.springmvc.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.resumeweb.entity.*;
import com.resumeweb.service.ResumeService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
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


    //处理第四步,Ajax交互
    //新建简历--简历项目信息
    @RequestMapping("/newProjectInfoAjax")
    @ResponseBody
    public String addProjectInfo(@RequestBody ProjectInfo projectInfo,
                               @RequestParam("itemOrder") int itemOrder,
                               BindingResult result,
                               HttpSession session){
        Integer userid = (Integer) session.getAttribute("currentUser");
        JSONObject resJson = new JSONObject();
        resJson.put("isSucceed",false);
        if(userid == null || userid < 0){
            resJson.put("errInfo","用户未登录，请求被拒绝");
            return resJson.toString();
        }
        if(result.hasErrors()) {
            resJson.put("errInfo","表单格式不正确");
            return resJson.toString();
        }
        Resume currentResume = (Resume)session.getAttribute("currentResume");
        if(currentResume == null){
            session.setAttribute("currentStep",0);
            resJson.put("errInfo","新建简历出现某些问题，您需要刷新页面重新新建！");
            return resJson.toString();
        }

        ArrayList<ProjectInfo> projectInfos = currentResume.getProjects();

        if(itemOrder + 1 > projectInfos.size()){
            //添加新的项目信息
            projectInfo.setUserId(userid);
            projectInfos.add( projectInfo);
        }else{
            //修改已有项目信息
            ProjectInfo temp = projectInfos.get(itemOrder);
            temp.setDescription(projectInfo.getDescription());
            temp.setProOrIntern(projectInfo.getProOrIntern());
            temp.setStartDate(projectInfo.getStartDate());
            temp.setEndDate(projectInfo.getEndDate());
            temp.setProjectName(projectInfo.getProjectName());
        }

        resJson.put("isSucceed",true);

        return resJson.toString();
    }

    //删除项目
    @RequestMapping("/removeProjectAjax")
    @ResponseBody
    public String removeProject(@RequestParam("itemOrder")int itemOrder,
                                HttpSession session){
        Integer userid = (Integer) session.getAttribute("currentUser");
        JSONObject resJson = new JSONObject();
        resJson.put("isSucceed",false);
        if(userid == null || userid < 0){
            resJson.put("errInfo","用户未登录，请求被拒绝");
            return resJson.toString();
        }

        Resume currentResume = (Resume)session.getAttribute("currentResume");
        if(currentResume == null){
            session.setAttribute("currentStep",0);
            resJson.put("errInfo","新建简历出现某些问题，您需要刷新页面重新新建！");
            return resJson.toString();
        }

        ArrayList<ProjectInfo> projectInfos = currentResume.getProjects();
        if(itemOrder < projectInfos.size()){
            projectInfos.remove(itemOrder);
        }

        JSONArray projects = new JSONArray();
        for(ProjectInfo p:currentResume.getProjects()){
            projects.put(new JSONObject(p.toString()));
        }

        resJson.put("projects",projects);
        resJson.put("isSucceed",true);

        return resJson.toString();
    }

    //处理第三步,Ajax交互
    //新建简历--简历教育信息
    @RequestMapping("/newEduInfoAjax")
    @ResponseBody
    public String addEduInfo(@RequestBody EduInfo eduInfo,
                             @RequestParam("itemOrder") int itemOrder,
                             BindingResult result,
                             HttpSession session){
        Integer userid = (Integer) session.getAttribute("currentUser");
        JSONObject resJson = new JSONObject();
        resJson.put("isSucceed",false);
        if(userid == null || userid < 0){
            resJson.put("errInfo","用户未登录，请求被拒绝");
            return resJson.toString();
        }
        if(result.hasErrors()) {
            resJson.put("errInfo","表单格式不正确");
            return resJson.toString();
        }
        Resume currentResume = (Resume)session.getAttribute("currentResume");
        if(currentResume == null){
            session.setAttribute("currentStep",0);
            resJson.put("errInfo","新建简历出现某些问题，您需要刷新页面重新新建！");
            return resJson.toString();
        }

        ArrayList<EduInfo> eduInfos = currentResume.getEducations();

        if(itemOrder + 1 > eduInfos.size()){
            //添加新的教育信息
            eduInfo.setUserId(userid);
            eduInfos.add(eduInfo);
        }else{
            //修改已有教育信息
            EduInfo temp = eduInfos.get(itemOrder);
            temp.setEdu(eduInfo.getEdu());
            temp.setMajor(eduInfo.getMajor());
            temp.setSchool(eduInfo.getSchool());
            temp.setRank(eduInfo.getRank());
            temp.setStartDate(eduInfo.getStartDate());
            temp.setEndDate(eduInfo.getEndDate());
        }

        resJson.put("isSucceed",true);

        return resJson.toString();
    }

    //删除教育信息
    @RequestMapping("/removeEduAjax")
    @ResponseBody
    public String removeEdu(@RequestParam("itemOrder")int itemOrder,
                            HttpSession session){
        Integer userid = (Integer) session.getAttribute("currentUser");
        JSONObject resJson = new JSONObject();
        resJson.put("isSucceed",false);
        if(userid == null || userid < 0){
            resJson.put("errInfo","用户未登录，请求被拒绝");
            return resJson.toString();
        }

        Resume currentResume = (Resume)session.getAttribute("currentResume");
        if(currentResume == null){
            session.setAttribute("currentStep",0);
            resJson.put("errInfo","新建简历出现某些问题，您需要刷新页面重新新建！");
            return resJson.toString();
        }

        ArrayList<EduInfo> eduInfos = currentResume.getEducations();
        if(itemOrder < eduInfos.size()){
            eduInfos.remove(itemOrder);
        }

        JSONArray educations = new JSONArray();
        for(EduInfo e:currentResume.getEducations()){
            educations.put(new JSONObject(e.toString()));
        }

        resJson.put("educations",educations);
        resJson.put("isSucceed",true);

        return resJson.toString();
    }

    //新建简历--保存简历
    @RequestMapping("/addNewResume")
    public String addNewResume(HttpSession session){
        session.setAttribute("currentStep",0);
        Integer userid = (Integer) session.getAttribute("currentUser");
        if(userid == null || userid < 0){
            return "redirect:/login";
        }
        try {
            Resume resume = (Resume) session.getAttribute("currentResume");
            ResumeService service = (ResumeService) context.getBean("resumeService");
            service.addNewResume(resume);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.removeAttribute("currentResume");
        }

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
