package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
      String username=req.getParameter("username");
      String password=req.getParameter("password");
      if("weg168".equals(username)&&password.equals("123456")){
          Cookie cookie=new Cookie("username",username);
          ///一周内有效
          cookie.setMaxAge(60*60*24*7);
          resp.addCookie(cookie);
          resp.getWriter().write("登录成功");
      }else{
          resp.getWriter().write("登录失败");
      }
    }
}
