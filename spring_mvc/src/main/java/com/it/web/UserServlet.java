package com.it.web;

import com.it.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletContext servletContext = req.getServletContext();
        // ApplicationContext app = (ApplicationContext) servletContext.getAttribute("app");
       // UserService userService= (UserService) app.getBean("userService");
        ServletContext servletContext=req.getServletContext();
        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserService userService= (UserService) app.getBean("userService");
        userService.save();
        System.out.println("执行成功");
    }
}
