package com.spring.demo.dans.service.impl;

import com.spring.demo.dans.dao.UsersRepository;
import com.spring.demo.dans.entity.dto.UserDto;
import com.spring.demo.dans.entity.enums.ResponseCode;
import com.spring.demo.dans.libraries.exception.BusinessLogicException;
import com.spring.demo.dans.service.api.UserService;
import com.spring.demo.dans.service.utility.ServiceBeanMapper;
import com.spring.demo.dans.service.utility.ServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * @author Rizky Perdana
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    private ServiceBeanMapper mapper = ServiceMapper.BEAN_MAPPER;

    @Override
    public Mono<UserDto> findByUsername(String username) {
        return usersRepository.findByUsername(username)
            .switchIfEmpty(Mono.error(new BusinessLogicException(
                ResponseCode.DATA_NOT_EXIST.getCode(),
                ResponseCode.DATA_NOT_EXIST.getMessage())))
            .map(mapper::map);
    }
}
