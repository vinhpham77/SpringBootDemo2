package com.example.SpringDemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {

    // Cross-cutting concern: logging
    @After("execution(* com.example.SpringDemo.controllers.UserController.*(..))")
    public void logAfterReturning(JoinPoint joinPoint) {
        System.out.println("Logging: " + joinPoint.getSignature().getName() + " executed");
    }
}
