package com.spring.demo.dans.rest.web.utilities;

import com.spring.demo.dans.entity.dto.JobDto;
import com.spring.demo.dans.entity.dto.param.AuthenticationParam;
import com.spring.demo.dans.rest.web.request.AuthenticationRequest;
import com.spring.demo.dans.rest.web.response.JobResponse;
import org.mapstruct.Mapper;

/**
 * @author Rizky Perdana
 */
@Mapper
public interface BeanMapper {

    JobResponse map(JobDto jobDto);
    AuthenticationParam map(AuthenticationRequest request);
}
