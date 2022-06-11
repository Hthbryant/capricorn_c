package com.lingyi.web.controller;

import com.lingyi.biz.config.exception.AuthException;
import com.lingyi.web.dto.BaseResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 咕噜科
 * ClassName: ExceptionController
 * date: 2022-06-10 23:55
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @RequestMapping("/test1")
    public BaseResponseDTO test1(){
        throw new AuthException("鉴权失败");
    }

}
