package com.sun.test;

import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
@Component("log")
public class LogDynamic implements InvocationHandler {
    private Object target;
    public Object bind(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method,Object[] args)throws Throwable{
        System.out.println(method.getName()+"being ...");
        Object result=method.invoke(target,args);
        System.out.println(method.getName()+"ending ...");
        return result;
    }
}
