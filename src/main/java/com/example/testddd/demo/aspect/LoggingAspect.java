package com.example.testddd.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.testddd.demo.service.*.get*(..))")
    public void loggerBefore() {
        System.out.println("get 으로 시작되는 메서드 시작!!");
    }

    @After("execution(* com.example.testddd.demo.service.*.get*(..))")
    public void loggerAfter() {
        System.out.println("get 으로 시작되는 메서드 끝!!");
    }

    @Around("execution(* com.example.testddd.demo.controller.UserController.*(..))")
    public Object loggerAround(ProceedingJoinPoint pjp) throws Throwable {
        long beforeTimeMillis = System.currentTimeMillis();
        System.out.println("[UserController] 실행 시간: "
                + pjp.getSignature().getDeclaringTypeName() + "."
                + pjp.getSignature().getName());
        Object result = pjp.proceed(); //proceed 를 기준으로 전후를 찍어준다.

        long afterTimeMillis = System.currentTimeMillis() - beforeTimeMillis;
        System.out.println("[UserController] 실행 완료: " + afterTimeMillis + "ms 소요 "
                + pjp.getSignature().getDeclaringTypeName() + "."
                + pjp.getSignature().getName());
        return result;
    }
}
