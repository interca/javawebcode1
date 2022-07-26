package web_test2;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("response1里面");
        resp.setStatus(302);//表示重定向
        //设置响应投，说明新的地址在哪里
       // resp.setHeader("Location","http://localhost:8080/web1/response2");

        //第二种请求定向的方式
          resp.sendRedirect("http://localhost:8080/web1");

    }
}
