package com.sun.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HelloAction {
    private String pname;
    private HelloBiz hello;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

@Autowired
    public void setHello(HelloBiz hello) {
        this.hello = hello;
    }
    public void sayHello(String name){
        String info= hello.sayHello(name);
        System.out.println(pname+"说"+info);
    }
}
