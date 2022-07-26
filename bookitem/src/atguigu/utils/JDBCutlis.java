package atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCutlis {
    private static DruidDataSource dataSource;
    static {
        Properties properties=new Properties();
        //读取文件的内容
       InputStream inputStream= JDBCutlis.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            //从流中加载数据
            properties.load(inputStream);
            dataSource= (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //获取数据库连接处中的链接
    public static Connection getConnection(){
        //如果返回null说明获取链接失败
      Connection connection=null;
        try {
            connection=dataSource.getConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

     //关闭链接
    public static  void close(Connection connection){
        try {
            if(connection!=null)
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(getConnection());
    }

}
