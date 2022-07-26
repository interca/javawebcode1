package web1_test1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RequestAPiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的资源路径
        System.out.println("URI="+req.getRequestURI());
        //决对路径
        System.out.println("URL="+req.getRequestURL());
        //获取客户的ip地址
        System.out.println("客户的Ip地址是:"+req.getRemoteHost());
        //获取请求头
        System.out.println("请求头是"+req.getHeader("User-Agent"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
