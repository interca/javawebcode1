package atguigu.dao.impl;

import atguigu.utils.JDBCutlis;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.management.ObjectName;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao {
    //使用DbUtils操作数据库
    private QueryRunner queryRunner=new QueryRunner();
    //用来执行update,insert delete语句
    public int update(String sql,Object...m){
        Connection connection= JDBCutlis.getConnection();
        try {
            //影响的行数
           return queryRunner.update(connection,sql,m);
        } catch (SQLException e) {
           e.printStackTrace();
        }finally {
            JDBCutlis.close(connection);
        }
        //执行失败如果返回-1
        return -1;
    }
    //返回一个javabean的java语句 type返回的对象类型，执行的sql语句，msql的参数值
    public<T>T queryForOne(Class<T>type, String sql, Object...m){
        Connection connection=JDBCutlis.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<T>(type),m);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCutlis.close(connection);
        }
    }

    //返回多个对象
    public <T> List<T> queryForList(Class<T>type, String sql, Object...m){
        Connection connection=JDBCutlis.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<>(type),m);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCutlis.close(connection);
        }
    }
    //返回一行一列的sql语句
    public Object queryForSingleValue(String sql,Object...m){
        Connection connection=JDBCutlis.getConnection();
        try {
           return  queryRunner.query(connection,sql,new ScalarHandler(),m);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutlis.close(connection);
        }
        return null;
    }
}



