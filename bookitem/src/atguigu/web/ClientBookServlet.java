package atguigu.web;

import atguigu.pojo.Book;
import atguigu.pojo.Page;
import atguigu.service.BookService;
import atguigu.service.impl.BookServiceImpl;
import atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientBookServlet extends BaseServlet{
    BookService bookService=new BookServiceImpl();
    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("经过前台");
        //当前页数
        int pageNo= WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        Page<Book>page=bookService.page(pageNo,pageSize);
        //保存到request域中
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);

    }
}
