package com.sun.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class T1 {
    public static void main(String[] args) {
        //测试spring容器内的bean是否能正常获取
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        //获取bean
       /* System.out.println(ioc.getBean("pooledDataSource"));
        System.out.println(ioc.getBean("sqlSessionFactory"));
        helloFactory hi=(helloFactory) ioc.getBean("helloFactory");
        hi.creatHello("tom");*/
        ExecutorService pool= Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    HelloAction action=(HelloAction) ioc.getBean("helloAction");
                    action.setPname("t-"+Thread.currentThread().getId());
                    int rand=(int)(Math.random()*100);
                    action.sayHello("tom"+rand);
                }
            });
        }
        pool.shutdown();
        TestBasicType test=(TestBasicType) ioc.getBean("testBasicType");
        System.out.println(test);
    }
}

