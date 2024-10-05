package com.sun.furn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller //注入容器
public class TestController {
    @RequestMapping("/hi")
    public String hi() {
        System.out.println("hi");
        return "hi"; //返回到默认视图解析器，进行路径拼接然后请求转发
    }
}

