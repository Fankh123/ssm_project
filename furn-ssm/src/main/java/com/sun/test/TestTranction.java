package com.sun.test;

import com.sun.furn.biz.IUser;
import com.sun.furn.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class TestTranction {
    public static void main(String[] args) throws Exception {
        ApplicationContext tx = new ClassPathXmlApplicationContext("beans.xml");
        IUser userbiz = (IUser) tx.getBean("userBiz");
        /*User user=new User();
        user.setPwd("开射");
        user.setRole(3);
        user.setSno("2716");
        user.setUname("cyy");
        try{
        userbiz.addUser(user);
    }catch (Exception e){
            e.printStackTrace();
        }
    }*/
        /*List<User> users = userbiz.getAllUser();

        // 输出用户信息
        for (User user : users) {
            System.out.println(user);
        }*/
        List<User> users1=userbiz.getUserByName("tsy");
        users1.forEach(System.out::println);
    }
}
