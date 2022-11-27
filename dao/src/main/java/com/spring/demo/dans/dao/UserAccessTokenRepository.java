package com.spring.demo.dans.dao;

import com.spring.demo.dans.entity.dao.UserAccessToken;
import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author Rizky Perdana
 */
@Repository
public interface UserAccessTokenRepository extends ReactiveCrudRepository<UserAccessToken, UUID> {

    Mono<UserAccessToken> findByUserId(UUID userId);
}
