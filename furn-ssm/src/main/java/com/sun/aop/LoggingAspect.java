package com.sun.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    @Pointcut("execution(* com.sun.test.*.toString(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void BeforeExecution(){
        System.out.println("toString执行前打印");
    }
    @Around("pointcut()")
    public Object  logAround(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Method: " + joinPoint.getSignature().getName());
        System.out.println("Target: " + joinPoint.getTarget().getClass().getName());
        System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));

        return "Modified Result";
    }

}
