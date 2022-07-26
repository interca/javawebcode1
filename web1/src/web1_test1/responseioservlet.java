package web1_test1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class responseioservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        resp.setCharacterEncoding("UTF-8");
        //设置浏览器字符集和服务器一样
        resp.setHeader("Content-Type","text/html;charset=UTF-8");
      //向客户端反馈,得到字符流
        PrintWriter printWriter=resp.getWriter();
        printWriter.write("你好啊");
    }

}
