package atguigu.dao.impl;

import atguigu.dao.BookDao;
import atguigu.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addBook(Book book) {
        String sql="insert into t_book(`name` , `author` , `price` , `sales` , `stock` , `img_path`)" +
                "values(?,?,?,?,?,?)";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());

    }

    @Override
    public int deleteBookId(Integer id) {
        String sql="delete from t_book where id=?";
        return update(sql,id);
    }

    @Override
    public int updateBook(Book book) {
        String sql="update t_book set `name`=?, `author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id=?";
        return update(sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
      String sql="select id,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book where id=?";
      return queryForOne(Book.class,sql,id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql="select id,`name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book";
        return queryForList(Book.class,sql);
    }

    /**
     * &#064;queryForPageTotalCount总的记录数
     */
    @Override
    public Integer queryForPageTotalCount() {
        String sql="select count(*) from t_book";
        Number count= (Number) queryForSingleValue(sql);
        return count.intValue();
    }

    /**
     *
     * @param begin   第几页
     * @param pageSize  每页的数量
     * @return  求当前页面的数据
     */
    @Override
    public List<Book> queryForPageItems(int begin, int pageSize) {
       String sql="select id,`name`,`author` , `price` , `sales` , `stock` ,`img_path` from t_book limit ?,?";
       return queryForList(Book.class,sql,begin,pageSize);
    }
}

