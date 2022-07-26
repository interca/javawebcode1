package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet{

    public void creatOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        //创建或者获取session对象
        HttpSession httpSession=req.getSession();
        boolean f=httpSession.isNew();
        String id=httpSession.getId();
        resp.getWriter().write("id是"+id+"<br/>");
        resp.getWriter().write("是否是之前创建的"+f);
    }
    public void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value");
    }

    public void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object object=req.getSession().getAttribute("key1");
        resp.getWriter().write(object+"");
    }
    //超时时长默认
    public void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //默认时长
       int max=req.getSession().getMaxInactiveInterval();
       resp.getWriter().write(max+"");
    }
    //设置
    public void Life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession session=req.getSession();
       session.setMaxInactiveInterval(3);
       resp.getWriter().write("三秒后关掉");
    }
}
