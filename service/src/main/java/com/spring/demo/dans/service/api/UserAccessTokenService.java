package com.spring.demo.dans.service.api;

import com.spring.demo.dans.entity.dto.UserAccessTokenDto;
import com.spring.demo.dans.entity.dto.param.UserAccessTokenParam;
import java.util.UUID;
import reactor.core.publisher.Mono;

/**
 * @author Rizky Perdana
 */
public interface UserAccessTokenService {

    Mono<UserAccessTokenDto> save(UserAccessTokenParam param);
}
