package servlet;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class upload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println("上传");
        //判断是不是多段数据，如果多段数据，才是文件的上传
        if (ServletFileUpload.isMultipartContent(req)) {
            //创建FileItemFactory的工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //用于解析上传数据的工具类
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            //解析上传的数据得到表单项FileitemFactory
            try {
                List<FileItem> list = servletFileUpload.parseRequest( req);
                //循环判断每一个表单项的类型
                for (FileItem fileItem : list) {
                    //普通表单项
                    if (fileItem.isFormField()) {
                        System.out.println("表单项的属性值:" + fileItem.getFieldName());
                        System.out.println("表单项的value:" + fileItem.getString("UTF-8"));
                    } else {
                        System.out.println("表单项的属性值是:" + fileItem.getFieldName());
                        System.out.println("表达性的文件名是:" + fileItem.getName());
                        fileItem.write(new File("C:\\Users\\waili\\Desktop\\usual\\Javaopenfile\\javawebcode\\javawebcode\\jsp\\src\\abc.jpg"));
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    }
