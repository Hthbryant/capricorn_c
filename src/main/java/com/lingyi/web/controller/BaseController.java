package com.lingyi.web.controller;

import com.lingyi.biz.common.annotation.ControllerParse;
import com.lingyi.biz.sdk.ExecServiceTemplate;
import com.lingyi.web.dto.BaseRequestDTO;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 咕噜科
 * ClassName: BaseController
 * date: 2022-06-10 21:23
 * Description:
 * version 1.0
 */
@RestController
public class BaseController {

    @ControllerParse
    protected <E extends BaseRequestDTO, T> void doExecute(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse
            , E request, ExecServiceTemplate<E, T> template) {
        template.apply(request);
    }

}
