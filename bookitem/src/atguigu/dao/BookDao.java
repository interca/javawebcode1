package atguigu.dao;

import atguigu.pojo.Book;

import java.util.List;

public interface BookDao {
    //添加图书
    int addBook(Book book);
    //删除图书
    int deleteBookId(Integer id);
    //修改
    int updateBook(Book book);
    //查询
    Book queryBookById(Integer id);
    List<Book>queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);
}
