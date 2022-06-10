package com.lingyi.biz.common.enums;

import lombok.Getter;

/**
 * @author 咕噜科
 * ClassName: ErrorStatus
 * date: 2022-06-10 23:27
 * Description:
 * version 1.0
 */
public enum ErrorStatus {

    SUCCESS("0","成功"),
    SYSTEM_ERROR("1001","系统异常"),
    TIMEOUT_ERROR("1002","系统超时，请稍后重试"),
    REQUEST_PARAM_WRONG("1003","参数错误，请检查参数")
    ;

    @Getter
    private String code;
    @Getter
    private String msg;

    ErrorStatus (String code,String msg) {
        this.code = code;
        this.msg = msg;
    }

}
