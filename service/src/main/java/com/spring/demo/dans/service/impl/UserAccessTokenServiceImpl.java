package com.spring.demo.dans.service.impl;

import com.spring.demo.dans.dao.UserAccessTokenRepository;
import com.spring.demo.dans.entity.dao.UserAccessToken;
import com.spring.demo.dans.entity.dto.UserAccessTokenDto;
import com.spring.demo.dans.entity.dto.param.UserAccessTokenParam;
import com.spring.demo.dans.entity.enums.ResponseCode;
import com.spring.demo.dans.libraries.exception.BusinessLogicException;
import com.spring.demo.dans.service.api.UserAccessTokenService;
import com.spring.demo.dans.service.utility.ServiceBeanMapper;
import com.spring.demo.dans.service.utility.ServiceMapper;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Rizky Perdana
 */
@Service
public class UserAccessTokenServiceImpl implements UserAccessTokenService {

    @Autowired
    private UserAccessTokenRepository userAccessTokenRepository;

    private ServiceBeanMapper mapper = ServiceMapper.BEAN_MAPPER;

    @Override
    public Mono<UserAccessTokenDto> save(UserAccessTokenParam param) {
        return findByUserId(param.getUserId())
            .switchIfEmpty(Mono.just(mapper.map(param)))
            .flatMap(data -> constructData(data, param))
            .flatMap(userAccessTokenRepository::save)
            .map(mapper::map);
    }

    private Mono<UserAccessToken> findByUserId(UUID id) {
        return userAccessTokenRepository.findByUserId(id)
            .switchIfEmpty(Mono.error(new BusinessLogicException(
                ResponseCode.DATA_NOT_EXIST.getCode(),
                ResponseCode.DATA_NOT_EXIST.getMessage())));
    }

    private Mono<UserAccessToken> constructData(UserAccessToken data,
        UserAccessTokenParam param) {
        return Mono.just(data)
            .flatMap(userAccessToken -> {
                userAccessToken.setToken(param.getToken());
                userAccessToken.setUpdatedAt(new Date());
                userAccessToken.setUpdatedBy("system");
                return Mono.just(userAccessToken);
            });
    }
}
