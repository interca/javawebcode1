package com.it.controller;

import com.it.domain.Role;
import com.it.domain.User;
import com.it.service.RoleService;
import com.it.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView=new ModelAndView();
        List<User> userList=userService.list();
        //设置模型对象
        modelAndView.addObject("userList",userList);
        //设置视图
        modelAndView.setViewName("user-list");
        return  modelAndView;
    }

    @RequestMapping("/saveUI")
    public ModelAndView saveUI(){
        ModelAndView modelAndView=new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return  modelAndView;
    }


    @RequestMapping("/save")
    public String save(User user,long[]roleIds){
        userService.save(user,roleIds);
        return "redirect:/user/list";
    }

    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") Long userId){
         userService.del(userId);
        return "redirect:/user/list";
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
       User user=userService.login(username,password);
       if(user!=null){
           //如果不为空，将user存储在session中
           session.setAttribute("user",user);
           //调回首页
           return "redirect:/index.jsp";
       }
        return "redirect:/login.jsp";
    }

}



