package com.spring.demo.dans.rest.web.controller;

import com.spring.demo.dans.entity.constant.ApiPath;
import com.spring.demo.dans.rest.web.configuration.CommonResponseHelper;
import com.spring.demo.dans.rest.web.request.AuthenticationRequest;
import com.spring.demo.dans.rest.web.response.AuthenticateResponse;
import com.spring.demo.dans.rest.web.response.BaseResponse;
import com.spring.demo.dans.rest.web.utilities.BeanMapper;
import com.spring.demo.dans.rest.web.utilities.Mapper;
import com.spring.demo.dans.service.api.AuthenticationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author Rizky Perdana
 */
@RestController
@RequestMapping(ApiPath.AUTH_ROUTE)
public class AuthenticateController {

    @Autowired
    private AuthenticationService authenticationService;

    private BeanMapper mapper = Mapper.BEAN_MAPPER;

    @PostMapping
    public Mono<BaseResponse<AuthenticateResponse>> generateToken(
        @Valid @RequestBody AuthenticationRequest request
    ) {
        return authenticationService.authenticate(mapper.map(request))
            .map(result -> AuthenticateResponse.builder()
                .token(result)
                .build())
            .map(CommonResponseHelper::constructSuccessResponse)
            .subscribeOn(Schedulers.elastic());
    }
}
