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
        /*System.out.println(ioc.getBean("pooledDataSource"));
        System.out.println(ioc.getBean("sqlSessionFactory"));*/
        //测试工厂实现set依赖注入
        /*helloFactory hi=(helloFactory) ioc.getBean("helloFactory");
        hi.creatHello("tom");*/
        //测试单例和多例，通过方法中引用getBean实现多例
        /*ExecutorService pool= Executors.newCachedThreadPool();
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
        pool.shutdown();*/
        LogDynamic logd=(LogDynamic) ioc.getBean("log");
        Hello h=(Hello)logd.bind(ioc.getBean("h"));
        h.hello("tom");
        /*TestBasicType test=(TestBasicType) ioc.getBean("testBasicType");
        System.out.println(test);*/
    }
}

