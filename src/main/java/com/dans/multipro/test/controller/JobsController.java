package com.dans.multipro.test.controller;

import com.dans.multipro.test.common.ApiPath;
import com.dans.multipro.test.common.BaseResponse;
import com.dans.multipro.test.common.ResponseCode;
import com.dans.multipro.test.dto.JobsDto;
import com.dans.multipro.test.service.JobsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Rizky Perdana
 */

@RestController
@RequestMapping(ApiPath.jobs)
@AllArgsConstructor
public class JobsController extends BaseController {

    private JobsService jobsService;

    @GetMapping
    public BaseResponse<List<JobsDto>> getAllJobs(){
        return buildResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), jobsService.getAllJobs());
    }

    @PostMapping(ApiPath.jobsById)
    public BaseResponse<JobsDto> findById(@PathVariable String id){
        return buildResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), jobsService.getById(id));
    }
}

