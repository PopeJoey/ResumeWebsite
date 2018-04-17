package main.java.test.controller;


import main.java.test.Bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }
    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String register() {
        return "register";
    }
    @RequestMapping(value="/index",method = RequestMethod.GET)
    public String index(ModelMap model) {
        return "index";
    }
    @RequestMapping(value="/template",method = RequestMethod.GET)
    public String template() {
        return "template";
    }
    @RequestMapping(value = "/contact",method = RequestMethod.GET)
    public String contact(){
        return "contact";
    }
    @RequestMapping(value = "/about",method = RequestMethod.GET)
    public String about(){
        return "about";
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
    public String testSession(HttpSession session){
//        User user=(User) session.getAttribute("currentUser");
//        System.out.println(user.getUsername());
//        ModelAndView mov=new ModelAndView("testSession");
        return "testSession";
    }
}
