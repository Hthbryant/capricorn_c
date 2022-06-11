package com.lingyi.biz.config.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author 咕噜科
 * ClassName: AspectTest
 * date: 2022-06-10 20:31
 * Description:
 * version 1.0
 */

@Aspect
@Component
public class AspectTest {

    @Pointcut("@annotation(com.lingyi.biz.common.annotation.TestAspect)")
    public void testCut () {

    }

    @Before("testCut()")
    public void beforeTest (JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("注解方式的aop 拦截成功，进行返回开始拦截，方法名为："+method.getName());
    }

    @After("testCut()")
    public void afterTest (JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("注解方式的aop 拦截成功，进行返回结束拦截，方法名为："+method.getName());
    }

    @AfterReturning(value = "testCut()", returning = "result")
    public void afterReturnTest (JoinPoint joinPoint, Object result) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("注解方式的aop 拦截成功，进行返回通知拦截，方法名为："+method.getName()+",返回结果为：" + result.toString());
    }

    @Around("testCut()")
    public Object aroundTest (ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("注解方式的aop 拦截成功,进行环绕拦截，方法名为："+method.getName()+"环绕开始");
        Object proceed = joinPoint.proceed();
        System.out.println("注解方式的aop 拦截成功,进行环绕拦截，方法名为："+method.getName()+"环绕结束");
        return proceed;
    }

    @AfterThrowing (value = "testCut()" ,throwing = "e")
    public void afterThrowTest (JoinPoint joinPoint ,Exception e) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("注解方式的aop 拦截成功，进行返回通知拦截，方法名为："+method.getName()+",异常为：" + e.getMessage());
    }

}
