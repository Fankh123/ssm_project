package com.sun.test;

import com.sun.furn.biz.IUser;
import com.sun.furn.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestTranction {
    public static void main(String[] args)  {
        ApplicationContext tx=new ClassPathXmlApplicationContext("beans.xml");
        IUser userbiz=(IUser) tx.getBean("userBiz");
        User user=new User();
        user.setPwd("开射");
        user.setRole(3);
        user.setSno("2716");
        user.setUname("cyy");
        try{
        userbiz.addUser(user);
    }catch (Exception e){
            e.printStackTrace();
        }
    }
}
