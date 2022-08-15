package test1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class contextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取web.xml中配置的上下文参数context-param
      ServletContext servletContext=getServletConfig().getServletContext();
      String str=servletContext.getInitParameter("username");
      String str2=servletContext.getContextPath();//工程路径
        String str3=servletContext.getRealPath("/");
        System.out.println("工程路径是"+str2);
        System.out.println("context-param的值是"+str);
        System.out.println("决对路径"+str3);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
