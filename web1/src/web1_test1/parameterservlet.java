package web1_test1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

public class parameterservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget请求");
        //获取请求的参数
       String username=req.getParameter("username");
       String password=req.getParameter("password");
        String []hobby=req.getParameterValues("hobby");
        System.out.println("用户名："+username+",密码:"+password+",爱好"+ Arrays.toString(hobby));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体的字符集
        System.out.println("dopost请求");
        req.setCharacterEncoding("UTF-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String []hobby=req.getParameterValues("hobby");
        System.out.println("用户名："+username+",密码:"+password+",爱好"+ Arrays.toString(hobby));
    }
}
