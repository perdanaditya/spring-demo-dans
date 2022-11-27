package com.spring.demo.dans.service.utility;

import com.spring.demo.dans.entity.dao.Users;
import com.spring.demo.dans.entity.dao.UserAccessToken;
import com.spring.demo.dans.entity.dto.UserAccessTokenDto;
import com.spring.demo.dans.entity.dto.UserDto;
import com.spring.demo.dans.entity.dto.param.UserAccessTokenParam;
import org.mapstruct.Mapper;

/**
 * @author Rizky Perdana
 */
@Mapper
public interface ServiceBeanMapper {

    UserDto map(Users users);
    UserAccessTokenDto map(UserAccessToken userAccessToken);
    UserAccessToken map(UserAccessTokenParam dto);
}
