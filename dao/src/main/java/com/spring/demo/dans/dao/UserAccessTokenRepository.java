package com.spring.demo.dans.dao;

import com.spring.demo.dans.entity.dao.UserAccessToken;
import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author Rizky Perdana
 */
public interface UserAccessTokenRepository extends ReactiveCrudRepository<UserAccessToken, UUID> {

    Mono<UserAccessToken> findByUserId(UUID userId);
}
