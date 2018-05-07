package com.resumeweb.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import com.resumeweb.service.ResumeService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

@Controller
public class NewResumeCtrl {
    public static ApplicationContext context;
    static {
        context = (WebApplicationContext) ContextLoader.getCurrentWebApplicationContext();
    }

    @RequestMapping("/new")
    public String newResume(Model model){
        return "redirect:/new/step/1";
    }

    @RequestMapping({"/new/step/{stepCount}","/new/step/{stepCount}/**"})
    public String addContent(Model model,
                             HttpServletRequest request,
                             @PathVariable("stepCount") String step){
        try{
            int stepCount = Integer.parseInt(step);
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
        }catch (NumberFormatException e){
            return redirectRoot(request);
        }

        return "";
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
