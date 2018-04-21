package com.resumeweb.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
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
}
