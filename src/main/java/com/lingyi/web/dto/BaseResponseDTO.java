package com.lingyi.web.dto;

import com.lingyi.biz.common.enums.ErrorStatus;
import lombok.Data;

/**
 * @author 咕噜科
 * ClassName: BaseResponseDTO
 * date: 2022-06-10 21:20
 * Description:
 * version 1.0
 */
@Data
public class BaseResponseDTO extends BaseDTO{

    private String code;
    private String msg;
    private String debugMsg;

    public BaseResponseDTO (String code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResponseDTO (String code,String msg,String debugMsg) {
        this.code = code;
        this.msg = msg;
        this.debugMsg = debugMsg;
    }

    public BaseResponseDTO (ErrorStatus errorStatus) {
        this.code = errorStatus.getCode();
        this.msg = errorStatus.getMsg();
    }

    public BaseResponseDTO (ErrorStatus errorStatus ,String debugMsg) {
        this.code = errorStatus.getCode();
        this.msg = errorStatus.getMsg();
        this.debugMsg = debugMsg;
    }

}
