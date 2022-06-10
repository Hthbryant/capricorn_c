package com.lingyi.biz.configuration.aop;

import com.lingyi.web.dto.BaseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 咕噜科
 * ClassName: AspectTest
 * date: 2022-06-10 20:31
 * Description:
 * version 1.0
 */

@Aspect
@Component
public class ControllerAspect {

    @Pointcut("@annotation(com.lingyi.biz.common.annotation.ControllerParse)")
    public void testCut () {

    }

    @Before("testCut()")
    public void beforeTest (JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
                if (arg instanceof BaseDTO) {
                    System.out.println("==BaseDTO 的子类==");
                    System.out.println(arg.toString());
                    for (Field field : arg.getClass().getDeclaredFields()) {
                        boolean accessible = field.isAccessible();
                        try {
                            field.setAccessible(true);
                            if ("bizSeqNo".equals(field.getName())) {
                                Object o = field.get(arg);
                                if (o == null || o == "") {
                                    field.set(arg,"C" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
                                }
                                break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            field.setAccessible(accessible);
                        }
                    }
                }


        }
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
        /*MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("注解方式的aop 拦截成功，进行返回通知拦截，方法名为："+method.getName()+",返回结果为：" + result.toString());*/
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
