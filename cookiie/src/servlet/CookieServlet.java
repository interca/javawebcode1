package servlet;

import util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet{

    public void creatCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        //创建cookie对象
        Cookie cookie=new Cookie("key1","value1");
        //通知客户端保存cookie
        resp.addCookie(cookie);
        resp.getWriter().write("cookie创建成功");
    }
    public void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        //返回数组
        Cookie[]cookies=req.getCookies();
        //遍历
        for (Cookie cookie : cookies) {
           resp.getWriter().write("name="+cookie.getName()+",value="+cookie.getValue()+"<br/>");
        }
        //获取指定
        Cookie iWantCookie= CookieUtils.findCookie("key1",cookies);
       resp.getWriter().write(iWantCookie.getName());
    }

    //修改
    public void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
       Cookie cookie=new Cookie("key1","newvalue");
       resp.addCookie(cookie);
       resp.getWriter().write("修改成功");
    }

    public void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        Cookie cookie=new Cookie("defaultLife","defaultLife");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
        resp.getWriter().write("-1");
    }

    public void testpath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        Cookie cookie=new Cookie("path1","path1");
        //getContextpath得到工程路径
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("path1");
    }


}
