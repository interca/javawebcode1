package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        //发sql查询学生信息
        //保存学生信息到request域中
        //请求转发到其他页面
        List<Student>list=new ArrayList<>();
        for(int i=0;i<10;i++){
            int t=i+1;
            list.add(new Student(i+1,"name"+t,18+t,"Phone"+t));
        }
        req.setAttribute("stuList",list);
        req.getRequestDispatcher("/test/showStudent.jsp").forward(req,resp);
    }
}


