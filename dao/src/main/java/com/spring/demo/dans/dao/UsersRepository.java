package com.spring.demo.dans.dao;

import com.spring.demo.dans.entity.dao.Users;
import java.util.UUID;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 * @author Rizky Perdana
 */
@Repository
public interface UsersRepository extends ReactiveCrudRepository<Users, UUID> {

    Mono<Users> findByUsername(String username);
}
