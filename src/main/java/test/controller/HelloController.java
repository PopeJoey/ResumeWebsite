package test.controller;


import jdk.nashorn.internal.runtime.GlobalConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        model.addAttribute("msg", "Spring MVC Hello World");
        model.addAttribute("name", "xu");
        return "login";
    }
    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public ModelAndView loginIn(@RequestParam (value = "username")String username, @RequestParam(value = "password" )String password
    ,HttpSession session){
        System.out.println(username+" "+password);
        //decide if the user is valid or the password is valid
        session.setAttribute("currentUser",new User(username,password));
        ModelAndView mav=new ModelAndView("home");
        mav.addObject("currentUser",new User(username,password));
        return mav;
    }
    @RequestMapping(value = "/testSession")
    public ModelAndView testSession(HttpSession session){
        User user=(User) session.getAttribute("currentUser");
        System.out.println(user.getUsername());
        ModelAndView mov=new ModelAndView("testSession");
        return mov;
    }
}
