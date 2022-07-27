package com.it.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 用户权限控制
 */
public class PrivilegeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断用户是否登录,判断session中有没有具体对象
        HttpSession session=request.getSession();
        Object user = session.getAttribute("user");
       if(user==null){
           //重定向
           response.sendRedirect(request.getContextPath()+"/login.jsp");
       }

       //放行，访问目标资源
       return true;
    }
}
