package com.it.controller;

import com.it.domain.Role;
import com.it.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    public RoleService roleService;

    //返回所以信息
    @RequestMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView=new ModelAndView();
       List<Role> roleList=roleService.list();
       //设置模型对象
       modelAndView.addObject("roleList",roleList);
       //设置视图
        modelAndView.setViewName("role-list");
        return  modelAndView;
    }

    //保存信息
    @RequestMapping("/save")
    public String save(Role role){
         roleService.save(role);
         //跳转上面地址
         return "redirect:/role/list";
    }




}
