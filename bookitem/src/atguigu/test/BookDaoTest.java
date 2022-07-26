package atguigu.test;

import atguigu.dao.BookDao;
import atguigu.dao.impl.BookDaoImpl;
import atguigu.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

    BookDao bookDao=new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"学习spring","黄裕甲",new BigDecimal(1999),10000,1,null));
    }

    @Test
    public void deleteBookId() {

    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"学习spring","黄裕",new BigDecimal(1999),10000,1,null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(10));
    }

    @Test
    public void queryBooks() {
        List<Book>list=bookDao.queryBooks();
        for(Book book:list){
            System.out.println(book);
        }
    }
    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }


  @Test
    public void queryForPageItems() {
      System.out.println(bookDao.queryForPageItems(8,4));
    }
}