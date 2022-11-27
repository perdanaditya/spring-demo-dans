package com.dans.multipro.test.outbound;

import com.dans.multipro.test.dto.JobsDto;

import java.util.List;

/**
 * @author Rizky Perdana
 */
public interface JobsOutbound {

    List<JobsDto> getAllJobs();

    JobsDto findById(String id);
}
