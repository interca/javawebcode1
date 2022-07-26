package atguigu.web;

import atguigu.pojo.User;
import atguigu.service.UserService;
import atguigu.service.impl.UserServiceImpl;
import atguigu.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class UserServlet extends BaseServlet {
    User user=null;
    UserService userService=new UserServiceImpl();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=  req.getParameter("username");
        String password=req.getParameter("password");
        User user1= WebUtils.copyParamToBean(req.getParameterMap(),new User());

        User user=userService.login(user1);
        if(user==null){
            //把错误信息和回显表单的信息保存再request域中
            req.setAttribute("msg","用户名或者密码错误");
            req.setAttribute("username",username);

            System.out.println("登录失败");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else{
            //保存用户登录信息
            req.getSession().setAttribute("user",user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String code=req.getParameter("code");

        User user= WebUtils.copyParamToBean(req.getParameterMap(),new User());

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
                int a=userService.RegistUser(user);
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

    //销毁session
    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getSession().invalidate();
        System.out.println(req.getContextPath());
        resp.sendRedirect(req.getContextPath());
    }
}
