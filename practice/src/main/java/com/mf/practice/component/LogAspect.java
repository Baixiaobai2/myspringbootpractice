package com.mf.practice.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 声明这是一个日志切面功能的组件
 */
@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.mf.practice.service..*.*(..))")
    public void log(){
        logger.info("before method log");
    }

    // 可以通过 JoinPoint 取到aop时的类名 方法名 方法参数等等
    @After("execution(* com.mf.practice.service..*.*(..))")
    public void logAfter(JoinPoint joinPoint){
        logger.info("after method log, " + joinPoint.getTarget().getClass());
        logger.info("after method log,  method = " + joinPoint.getSignature());
    }

}
