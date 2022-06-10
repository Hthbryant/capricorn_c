package com.lingyi.biz.configuration.exception;

/**
 * @author 咕噜科
 * ClassName: AuthException
 * date: 2022-06-10 23:45
 * Description:
 * version 1.0
 */
public class AuthException extends RuntimeException{

    private String errorMsg;

    public AuthException () {
        
    }

    public AuthException (String errorMsg) {
        super(errorMsg);
    }
}
