package com.sun.test;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component("h")
@Lazy
public class HelloBiz implements Hello{
    public String sayHello(String name){
        return "hello: Mr."+name;
    }
    public HelloBiz(){
        System.out.println("HelloBiz被创建");
    }
    public void hello(String name){
    System.out.println("Hello"+name);
    }
}
