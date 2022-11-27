package com.spring.demo.dans.rest.web.utilities;

import com.spring.demo.dans.entity.dto.Job;
import com.spring.demo.dans.rest.web.response.JobResponse;
import org.mapstruct.Mapper;

/**
 * @author Rizky Perdana
 */
@Mapper
public interface BeanMapper {

    JobResponse map(Job job);
}
