package test1;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

public class Helloservlet implements Servlet {
    public Helloservlet() {
        System.out.println("构造器");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init初始化");
        System.out.println("Helloservlet的别名是"+servletConfig.getServletName());
        System.out.println("username的值是"+servletConfig.getInitParameter("username"));
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
     //用来处理请求和响应的
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) servletRequest;//类型转换
        //子类有geimethod方法，判断是gei还是postS
        String method=httpServletRequest.getMethod();
        System.out.println(method);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
