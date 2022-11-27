package com.spring.demo.dans.service.api;

import com.spring.demo.dans.entity.dto.param.AuthenticationParam;
import reactor.core.publisher.Mono;

/**
 * @author Rizky Perdana
 */
public interface AuthenticationService {

    Mono<String> authenticate(AuthenticationParam param);
}
