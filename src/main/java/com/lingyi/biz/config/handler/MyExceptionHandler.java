package com.lingyi.biz.config.handler;

import com.lingyi.biz.common.enums.ErrorStatus;
import com.lingyi.biz.config.exception.AuthException;
import com.lingyi.web.dto.BaseResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author 咕噜科
 * ClassName: MyExceptionHandler
 * date: 2022-06-10 23:25
 * Description:
 * version 1.0
 */
@ControllerAdvice
public class MyExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    private BaseResponseDTO exceptionHandler(Exception e) {
        logger.info("======全局异常捕获 exceptionHandler======");
        logger.error("Exception:", e);
        return new BaseResponseDTO(ErrorStatus.SYSTEM_ERROR, e.getMessage());
    }

    @ExceptionHandler(value = AuthException.class)
    @ResponseBody
    private BaseResponseDTO authExceptionHandler(HttpServletResponse httpServletResponse,Exception e) {
        logger.info("======全局异常捕获 authExceptionHandler======");
        logger.error("Exception:", e);
        httpServletResponse.setStatus(401);
        return new BaseResponseDTO(ErrorStatus.NO_PERMISSION, e.getMessage());
    }

}
