package com.lingyi.biz.sdk;

import com.lingyi.web.dto.BaseDTO;

/**
 * @author 咕噜科
 * ClassName: ExecServiceTemplate
 * date: 2022-06-10 22:22
 * Description:
 * version 1.0
 */
@FunctionalInterface
public interface ExecServiceTemplate <E extends BaseDTO,T> {
    void apply(E requestDTO);
}
