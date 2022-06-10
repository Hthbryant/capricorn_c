package com.lingyi.biz.common.annotation;

import java.lang.annotation.*;

/**
 * @author 咕噜科
 * ClassName: ControllerParse
 * date: 2022-06-10 21:25
 * Description:
 * version 1.0
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface ControllerParse {
}
