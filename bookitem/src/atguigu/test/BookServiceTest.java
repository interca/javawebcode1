package atguigu.test;

import atguigu.pojo.Book;
import atguigu.service.BookService;
import atguigu.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
     BookService bookService=new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"学习mysql","裕甲",new BigDecimal(1999),10000,1,null));
    }

    @Test
    public void deleteBookId() {
        bookService.deleteBookId(22);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(21,"学习spring2","黄裕甲",new BigDecimal(1999),10000,1,null));
    }

    @Test
    public void queryBookId() {
        System.out.println(bookService.queryBookId(3));
    }

    @Test
    public void queryBooks() {
        List<Book>list=bookService.queryBooks();
        for(Book book:list){
            System.out.println(book);
        }
    }
    @Test
    public  void page(){
        System.out.println(bookService.page(1,4));
    }
}