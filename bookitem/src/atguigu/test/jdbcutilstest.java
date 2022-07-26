package atguigu.test;

import atguigu.utils.JDBCutlis;
import org.junit.Test;

import java.sql.Connection;

public class jdbcutilstest {
   @Test
    public void testjdbcutils(){
       Connection connection=JDBCutlis.getConnection();
       System.out.println(connection);
       JDBCutlis.close(connection);
   }
}
