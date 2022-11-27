package com.dans.multipro.test.service;

import com.dans.multipro.test.common.BaseResponse;
import com.dans.multipro.test.dto.LoginRequestDto;

/**
 * @author Rizky Perdana
 */
public interface LoginService {

   String login(LoginRequestDto requestDto);
}
