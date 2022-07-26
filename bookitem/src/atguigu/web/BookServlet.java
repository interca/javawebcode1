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
import java.util.List;

public class BookServlet extends BaseServlet {
    BookService bookService=new BookServiceImpl();
     //添加
   public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.println("添加");
       Book book= WebUtils.copyParamToBean(req.getParameterMap(),new Book());
       bookService.addBook(book);
       //请求重定向
       resp.sendRedirect(req.getContextPath()+"/manager/BookServlet?action=page");
    }
    //修改
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("upadate");
        Book book=WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.updateBook(book);
        resp.sendRedirect(req.getContextPath()+"/manager/BookServlet?action=page");
    }
    //查询
   public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(1);
       //查询全部图书
        List<Book>books=bookService.queryBooks();
        //把全部数据保存再request中
        req.setAttribute("books",books);
        //请求转发
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
    //删除
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("id");
        bookService.deleteBookId(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath()+"/manager/BookServlet?action=page");
    }

    //获取图书信息，便于修改
    public  void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("1");
      String id=req.getParameter("id");
      Book book=bookService.queryBookId(Integer.valueOf(id));
      req.setAttribute("book",book);
      req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }

    /**
     * 处理分页功能
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //当前页数
         int pageNo=WebUtils.parseInt(req.getParameter("pageNo"),1);
         int pageSize=WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
         Page<Book>page=bookService.page(pageNo,pageSize);
         //保存到request域中
        req.setAttribute("page",page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }

}
