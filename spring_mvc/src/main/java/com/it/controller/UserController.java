package com.it.controller;

import com.it.domain.User;
import com.it.domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/quick")
    public  String save(){
        System.out.println("Controller save runninh");
         return "/success.jsp";
    }

    //Mode封装数据  View展示数据
    @RequestMapping("/quick2")
    public ModelAndView save2(){
      ModelAndView modelAndView=new ModelAndView();
       //在域中保存数据然后设置到success.jsp中
        modelAndView.addObject("username","111");
      modelAndView.setViewName("/success.jsp");
      return modelAndView;
    }
     //框架会自动帮你生成对象
    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        //在域中保存数据然后设置到success.jsp中
        modelAndView.addObject("username","222");
        modelAndView.setViewName("/success.jsp");
        return modelAndView;
    }
    @RequestMapping("/quick4")
    public String save4(HttpServletRequest request){
        //在域中保存数据然后设置到success.jsp中
       request.setAttribute("username","44444");
       return "/success.jsp";
    }

    //回显数据
    @RequestMapping("/quick5")
    public void save5(HttpServletResponse response) throws IOException {
        //处理乱码
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("你好");
    }

    //期望springmvc把user转换为字符串
    @RequestMapping("/quick6")
    @ResponseBody//返回字符串，不会页面跳转
    public User save6() throws IOException {
       User user=new User();
       user.setUsername("黄裕甲");
       user.setAge(20);
      return  user;
    }

    //接受数据
    @RequestMapping("/quick7")
    @ResponseBody//返回字符串，不会页面跳转
    public void save7(String username,int age) throws IOException {
        System.out.println(username);
        System.out.println(age);
    }

    //自动封装对象
    @RequestMapping("/quick8")
    @ResponseBody//返回字符串，不会页面跳转
    public void save8(User user) throws IOException {
        System.out.println(user);
    }

    //自动封装对象
    @RequestMapping("/quick9")
    @ResponseBody//返回字符串，不会页面跳转
    public void save9(VO vo) throws IOException {
        System.out.println(vo);
    }

    //自动封装对象
    @RequestMapping("/quick10")
    @ResponseBody//返回字符串，不会页面跳转
    public void save10(@RequestBody List<User>userList) throws IOException {
        System.out.println(userList);
    }

    //自动封装对象
    //localhost/8080/user/quick11/zhangsan
    //可以不用输入？username=zhangsan就能得到值
    @RequestMapping("/quick11/{username}")
    @ResponseBody//返回字符串，不会页面跳转
    public void save11(@PathVariable(value = "username") String username) throws IOException {
        System.out.println(username);
    }

    @RequestMapping("/quick12")
    @ResponseBody//返回字符串，不会页面跳转
    public void save12(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println(request);
        System.out.println(response);
    }

    @RequestMapping("/quick13")
    @ResponseBody//返回字符串，不会页面跳转
    public void save13(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        System.out.println(uploadFile);
        //获取文件名称
        String name=uploadFile.getOriginalFilename();
        //指定下载地方
        uploadFile.transferTo(new File("C:\\Users\\waili\\Desktop\\usual\\upload\\"+name));
    }
}


