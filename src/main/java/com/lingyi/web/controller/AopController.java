package com.lingyi.web.controller;

import com.lingyi.biz.common.annotation.TestAspect;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 咕噜科
 * ClassName: AopController
 * date: 2022-06-10 20:53
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/aop")
public class AopController {

    @TestAspect
    @RequestMapping("/test")
    public String testAspect () {
        System.out.println("========================");
        return "ok";
    }
}
