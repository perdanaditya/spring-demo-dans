package com.dans.multipro.test.controller;

import com.dans.multipro.test.common.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 * @author Rizky Perdana
 */

@ControllerAdvice
public abstract class BaseController {

    public static BaseResponse buildResponse(String code, String message, Object data) {
        return BaseResponse.builder()
                .code(code)
                .message(message)
                .data(data)
                .build();
    }

}
