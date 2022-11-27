package com.dans.multipro.test.service;

import com.dans.multipro.test.common.BaseResponse;
import com.dans.multipro.test.common.BusinessLogicException;
import com.dans.multipro.test.common.ResponseCode;
import com.dans.multipro.test.dto.LoginRequestDto;
import com.dans.multipro.test.repository.UserRepository;
import com.dans.multipro.test.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Rizky Perdana
 */

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService{

    private UserRepository userRepository;

    private JwtUtils jwtUtils;

    @Override
    public String login(LoginRequestDto requestDto) {
        return userRepository.findByUsernameAndPassword(requestDto.getUsername(), requestDto.getPassword())
                .map(user -> jwtUtils.generateToken(user.getUsername(), user.getPassword()))
                .orElseThrow(() -> new BusinessLogicException(ResponseCode.USER_NAME_PASSOWRD_NOT_MATCH.getCode(),ResponseCode.USER_NAME_PASSOWRD_NOT_MATCH.getCode()));
    }
}
