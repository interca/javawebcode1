package test1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class HellowServlet3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我是get");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我是post");
    }
}
