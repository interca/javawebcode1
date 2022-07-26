package atguigu.web;

import atguigu.pojo.User;
import atguigu.service.UserService;
import atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

public class RegistServlet extends HttpServlet {
    //调用dao层
    UserService userService=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String code=req.getParameter("code");
        code=code.toLowerCase();
        //检测验证码
        if(code.equals("abcde")){
            //检测用户名
            if(userService.existsUsername(name)){
                req.setAttribute("msg","用户名存在");
                System.out.println("用户名"+name+"已经存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else {
                //保存数据库
                int a=userService.RegistUser(new User(0,name,password,email));
                if(a!=-1)
                    req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
                else req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }
        }else {
            //验证码不对，请求转发，跳回注册页面
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",name);
            req.setAttribute("email",email);
            System.out.println("验证码为"+code+",不可用");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
