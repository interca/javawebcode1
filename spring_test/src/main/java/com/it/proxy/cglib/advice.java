package com.it.proxy.cglib;

public class advice {
    public void before(){
        System.out.println("之前");
    }
    public  void after(){
        System.out.println("之后");
    }
}
