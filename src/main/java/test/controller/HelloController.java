package main.java.test.controller;


import main.java.test.Bean.LogAndRegisterService;
import main.java.test.Bean.UserSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HelloController {
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String logIn(){
        return "login";
    }
    @RequestMapping(value="/home",method = RequestMethod.POST)
    public String home(@RequestParam(value = "username")String username,
                        @RequestParam(value = "password")String password,HttpSession session) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("main/java/test/Bean/Beans.xml");
        LogAndRegisterService lg=(LogAndRegisterService) context.getBean("LogAndRegisterService");
        if ( lg.logIn(username,password)){
            session.setAttribute("currentUser",new UserSession(username,password));
            return "home";
        }else {
            return "login";
        }

    }
//    @RequestMapping(value = "/home",method = RequestMethod.POST)
//    public ModelAndView loginIn(@RequestParam (value = "username")String username, @RequestParam(value = "password" )String password
//    ,HttpSession session){
//        System.out.println(username+" "+password);
//        //decide if the user is valid or the password is valid
//        session.setAttribute("currentUser",new UserSession(username,password));
//        ModelAndView mav=new ModelAndView("home");
//        mav.addObject("currentUser",new UserSession(username,password));
//        return mav;
//    }
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

    @RequestMapping(value = "/testSession")
    public String testSession(HttpSession session){
//        UserSession user=(UserSession) session.getAttribute("currentUser");
//        System.out.println(user.getUsername());
//        ModelAndView mov=new ModelAndView("testSession");
        return "testSession";
    }
}
