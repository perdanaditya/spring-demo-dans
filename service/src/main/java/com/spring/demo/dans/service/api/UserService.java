package com.spring.demo.dans.service.api;

import com.spring.demo.dans.entity.dto.UserDto;
import reactor.core.publisher.Mono;

/**
 * @author Rizky Perdana
 */
public interface UserService {

    Mono<UserDto> findByUsername(String username);
}
