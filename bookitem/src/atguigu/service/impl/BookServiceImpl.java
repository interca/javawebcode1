package atguigu.service.impl;

import atguigu.dao.BookDao;
import atguigu.dao.impl.BookDaoImpl;
import atguigu.pojo.Book;
import atguigu.pojo.Page;
import atguigu.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDao bookDao=new BookDaoImpl();
    @Override
    public void addBook(Book book) {
       bookDao.addBook(book);
    }

    @Override
    public void deleteBookId(Integer id) {
         bookDao.deleteBookId(id);
    }

    @Override
    public void updateBook(Book book) {
       bookDao.updateBook(book);
    }

    @Override
    public Book queryBookId(Integer id) {
        return  bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
      return  bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book>page=new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页数量
        page.setPageSize(pageSize);
        //求总的记录数
        Integer pageTotalCount=bookDao.queryForPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        //求总页数
        Integer pageTotal=pageTotalCount/pageSize;
        //除不尽，总页数加一
        if(pageTotalCount%pageSize!=0)pageTotal++;
        page.setPageTotal(pageTotal);
        //求当前页面的数据
        int begin=(page.getPageNo()-1)*pageSize;
        List<Book>item=bookDao.queryForPageItems(begin,pageSize);
        page.setItems(item);
       return  page;
    }
}
