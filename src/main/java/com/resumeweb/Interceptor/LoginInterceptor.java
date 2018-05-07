package com.resumeweb.Interceptor;


import com.resumeweb.entity.UserSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//拦截器，实现url的拦截处理，没有登录的用户无法访问个人中心等
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //未登录时可以访问的url
        String[] allowUrls=new String[]{"/homepage","/login","/about","/contact","/register","/template"};
        HttpSession session=httpServletRequest.getSession();
        String url=httpServletRequest.getRequestURL().toString();

        for (String strUrl:allowUrls){
            if (url.equals("http://localhost:8080/resumeweb"+strUrl)){
                return true;
            }
        }
        UserSession user=(UserSession)session.getAttribute("currentUser");
        if (user==null){

            httpServletResponse.sendRedirect("http://localhost:8080/resumeweb/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
