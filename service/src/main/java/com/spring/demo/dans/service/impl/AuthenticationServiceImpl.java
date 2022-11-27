package com.spring.demo.dans.service.impl;

import com.spring.demo.dans.entity.dto.UserAccessTokenDto;
import com.spring.demo.dans.entity.dto.param.AuthenticationParam;
import com.spring.demo.dans.entity.dto.param.UserAccessTokenParam;
import com.spring.demo.dans.libraries.helper.JWTHelper;
import com.spring.demo.dans.service.api.AuthenticationService;
import com.spring.demo.dans.service.api.UserAccessTokenService;
import com.spring.demo.dans.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Rizky Perdana
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAccessTokenService userAccessTokenService;

    @Override
    public Mono<String> authenticate(AuthenticationParam param) {
        return userService.findByUsername(param.getUsername())
            .flatMap(user -> {
                String token = JWTHelper.generateToken(param.getUsername(), param.getPassword());
                return userAccessTokenService.save(UserAccessTokenParam.builder()
                    .token(token)
                    .userId(user.getId())
                    .expireAt(JWTHelper.getExpirationDateFromToken(token))
                    .build());
            })
            .map(UserAccessTokenDto::getToken);
    }
}
