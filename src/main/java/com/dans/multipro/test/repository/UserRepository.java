package com.dans.multipro.test.repository;

import com.dans.multipro.test.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Rizky Perdana
 */

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String userName, String password);
}
