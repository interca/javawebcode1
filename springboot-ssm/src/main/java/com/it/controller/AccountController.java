package com.it.controller;

import com.it.domain.Account;
import com.it.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    //保存
    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    public  String save(Account account){
        System.out.println("1");
        accountService.save(account);
        return "保存成功";
    }

    @RequestMapping(value = "/save2",produces = "text/html;charset=UTF-8")
    public  String save2(){
        System.out.println("1");
        Account account=new Account();
        account.setName("李华");
        account.setMoney(20000);
        accountService.save(account);
        return "保存成功";
    }
    //查询
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("进入方法");
        System.out.println(accountService);
        List<Account> accountServiceAll = accountService.findAll();
        System.out.println(accountServiceAll);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("accountList1",accountServiceAll);
        modelAndView.setViewName("pages/accountList.jsp");
        return modelAndView;
    }
}
