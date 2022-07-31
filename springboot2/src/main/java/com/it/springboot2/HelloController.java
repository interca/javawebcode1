package com.it.springboot2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

   @Value("${name}")
   private String name;

   @Value("${person.name}")
   private  String name2;

   @Value("${address[0]}")
   String name3;

   //用注解获取配置文件的属性
   @Autowired
   private Environment environment;
   @RequestMapping("/hello5")
   public String hello5(){
       return  environment.getProperty("person.name");
   }

   @RequestMapping("/hello4")
   public String hello4(){
       return name3;
   }
   @RequestMapping("/hello3")
   public  String hello3(){
       return  name2;
   }
   @RequestMapping("/hello2")
   public  String hello2(){
       return name;
   }

    @RequestMapping("/hello")
    public String hello(){
        return "hello-springboot2";
    }

    @Autowired
    Person person;
    @RequestMapping("hello6")
    public  void hello6(){
        System.out.println(person);
    }

}



