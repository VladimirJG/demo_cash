package ru.danilov.demo_cash.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* ru.danilov.demo_cash.controller.*.*(..))")
    public void logBeforeControllerMethods() {
        System.out.println("Logging: Before executing controller method");
    }

    @Before("execution(* ru.danilov.demo_cash.service.*.*(..))")
    public void logBeforeServiceMethods() {
        System.out.println("Logging: Before executing service method");
    }
}
