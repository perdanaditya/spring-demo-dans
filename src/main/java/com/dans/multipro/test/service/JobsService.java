package com.dans.multipro.test.service;

import com.dans.multipro.test.dto.JobsDto;

import java.util.List;

/**
 * @author Rizky Perdana
 */
public interface JobsService {

    List<JobsDto> getAllJobs();

    JobsDto getById(String id);
}
