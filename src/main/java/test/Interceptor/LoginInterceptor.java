package main.java.test.Interceptor;

import main.java.test.Bean.UserSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String[] allowUrls=new String[]{"/index","/login","/about","/contact","/register","/template","/home"};
        HttpSession session=httpServletRequest.getSession();
        String url=httpServletRequest.getRequestURL().toString();

        for (String strUrl:allowUrls){
            if (url.equals("http://localhost:8080"+strUrl)){
                return true;
            }
        }
        UserSession user=(UserSession)session.getAttribute("currentUser");
        if (user==null){

            httpServletResponse.sendRedirect("http://localhost:8080/login");
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
