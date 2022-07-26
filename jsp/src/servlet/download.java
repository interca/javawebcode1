package servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//重网页下载文件
public class download extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取下载的文件名
        String download="default.jpg";
        //读取要下载的文件内容
        ServletContext servletContext=getServletContext();
        //获取要下载的文件类型
        String type=servletContext.getMimeType("/file"+download);
        //告诉客户端返回的数据类型
        resp.setContentType(type);
        //告诉用户是下载的,attachment附件表示下载使用，filename文件名
        resp.setHeader("Content-Disposition","attachment;filename="+download);//收到的数据怎么处理
        //"/表示工程名"到web目录
        //获取输入流
        InputStream resourceAsStream= servletContext.getResourceAsStream("/file/"+download);
        byte[]b=new byte[1024];
        //获取输出流
        OutputStream outputStream=resp.getOutputStream();
        //将输入流的内容复制给输出流
        IOUtils.copy(resourceAsStream,outputStream);

    }
}
