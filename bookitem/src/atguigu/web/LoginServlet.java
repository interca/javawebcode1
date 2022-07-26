package atguigu.web;

import atguigu.pojo.User;
import atguigu.service.UserService;
import atguigu.service.impl.UserServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username=  req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        User user=userService.login(new User(0,username,password,"ssss"));
        if(user==null){
            //把错误信息和回显表单的信息保存再request域中
            req.setAttribute("msg","用户名或者密码错误");
            req.setAttribute("username",username);

            System.out.println("登录失败111");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            System.out.println("登录成功123");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
}
