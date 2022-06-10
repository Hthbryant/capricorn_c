package com.lingyi.web.controller;

import com.lingyi.biz.common.annotation.ControllerParse;
import com.lingyi.biz.common.annotation.TestAspect;
import com.lingyi.web.dto.BaseRequestDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 咕噜科
 * ClassName: AopController
 * date: 2022-06-10 20:53
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/aop")
public class AopController extends BaseController{

    @TestAspect
    @RequestMapping("/test")
    public String testAspect () {
        return "ok";
    }

    @ControllerParse
    @RequestMapping("/test2")
    public void test (@RequestBody BaseRequestDTO request,
                         HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse) {
        doExecute(httpServletRequest,httpServletResponse,request,(requestDTO)-> {
            System.out.println("request:" + request);
        });
    }
}
