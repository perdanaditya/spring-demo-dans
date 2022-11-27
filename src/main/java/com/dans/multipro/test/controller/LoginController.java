package com.dans.multipro.test.controller;

import com.dans.multipro.test.common.ApiPath;
import com.dans.multipro.test.common.BaseResponse;
import com.dans.multipro.test.common.ResponseCode;
import com.dans.multipro.test.dto.LoginRequestDto;
import com.dans.multipro.test.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Rizky Perdana
 */

@RestController
@RequestMapping(ApiPath.login)
@AllArgsConstructor
public class LoginController extends BaseController{

    private LoginService loginService;

    @PostMapping
    public BaseResponse<String> login(@RequestBody LoginRequestDto requestDto){
        return buildResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), loginService.login(requestDto));
    }
}
