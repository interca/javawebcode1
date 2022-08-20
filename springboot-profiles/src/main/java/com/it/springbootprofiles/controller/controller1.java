package com.it.springbootprofiles.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class controller1 {

    @GetMapping("/{id}")
    public  String  quick(@PathVariable Integer id){
        System.out.println(id);
        return "hello boot";
    }
}
