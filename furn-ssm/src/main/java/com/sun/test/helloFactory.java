package com.sun.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy

public class helloFactory {

    public HelloBiz hello;
    int size;

    public void creatHello(String name){
        System.out.println(hello.sayHello(name));
    }
    @Autowired
    @Qualifier("h")
    public void setHello1(HelloBiz hello, @Value("${user.size}")int size) {
        System.out.println("setHello被调用");
        this.hello= hello;
        this.size=size;
    }


}
