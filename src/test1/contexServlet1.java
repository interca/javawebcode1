package test1;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;

public class contexServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ServletContext servletContext=getServletContext();
      servletContext.setAttribute("key","value");
        System.out.println(servletContext.getAttribute("key"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
