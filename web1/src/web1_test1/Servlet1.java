package web1_test1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Servlet1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String useranme= req.getParameter("username");//获取请求参数
        System.out.println("在servlet1中查看参数"+useranme);
        //所有servlet都可以看到
        req.setAttribute("key","1来的资料");
        //到servlet，要以斜杠打头,/表示http://ip:port/工程名/    ->映射到目录
       RequestDispatcher requestDispatcher= req.getRequestDispatcher("/Servlet2");
       //跳到servlet2
       requestDispatcher.forward(req,resp);

    }
}
