package com.lingyi.web.dto;

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

    public BaseResponseDTO (String code,String msg) {
        this.code = code;
        this.msg = msg;
    }

}
