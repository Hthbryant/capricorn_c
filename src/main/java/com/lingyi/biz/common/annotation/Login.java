package com.lingyi.biz.common.annotation;

import java.lang.annotation.*;

/**
 * @author 咕噜科
 * ClassName: Login
 * date: 2022-06-10 20:18
 * Description: 登录校验注解
 * version 1.0
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Login {
}
