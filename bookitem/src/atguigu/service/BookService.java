package atguigu.service;

import atguigu.pojo.Book;
import atguigu.pojo.Page;

import javax.print.DocFlavor;
import java.util.List;

public interface BookService {
    public  void addBook(Book book);

    public void deleteBookId(Integer id);

    void updateBook(Book book);

    Book queryBookId(Integer id);

    List<Book>queryBooks();

    Page<Book> page(int pageNo, int pageSize);
}
