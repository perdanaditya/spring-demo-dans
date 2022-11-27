package com.dans.multipro.test.service;

import com.dans.multipro.test.common.BusinessLogicException;
import com.dans.multipro.test.common.ResponseCode;
import com.dans.multipro.test.dto.JobsDto;
import com.dans.multipro.test.outbound.JobsOutbound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Rizky Perdana
 */
@Service
@AllArgsConstructor
public class JobsServiceImpl implements JobsService{

    private JobsOutbound jobsOutbound;

    @Override
    public List<JobsDto> getAllJobs() {
        return jobsOutbound.getAllJobs();
    }

    @Override
    public JobsDto getById(String id) {
        return Optional.ofNullable(jobsOutbound.findById(id))
                .orElseThrow(() -> new BusinessLogicException(ResponseCode.FAILED.getCode(), ResponseCode.FAILED.getMessage()));
    }
}
