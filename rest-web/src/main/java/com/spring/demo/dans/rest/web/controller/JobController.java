package com.spring.demo.dans.rest.web.controller;

import com.spring.demo.dans.entity.constant.ApiPath;
import com.spring.demo.dans.rest.web.configuration.CommonResponseHelper;
import com.spring.demo.dans.rest.web.response.BaseResponse;
import com.spring.demo.dans.rest.web.response.JobResponse;
import com.spring.demo.dans.rest.web.utilities.BeanMapper;
import com.spring.demo.dans.rest.web.utilities.Mapper;
import com.spring.demo.dans.service.api.JobService;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author Rizky Perdana
 */
@Slf4j
@RestController
@RequestMapping(ApiPath.JOB_ROUTE)
public class JobController {

    @Autowired
    private JobService jobService;

    private BeanMapper mapper = Mapper.BEAN_MAPPER;

    @GetMapping
    public Mono<BaseResponse<List<JobResponse>>> findAllJob(){
        return jobService.findAllJob()
            .map(mapper::map)
            .collectList()
            .map(CommonResponseHelper::constructSuccessResponse)
            .subscribeOn(Schedulers.elastic());
    }

    @GetMapping(ApiPath.BY_ID)
    public Mono<BaseResponse<JobResponse>> findAllJob(
        @PathVariable UUID id){
        return jobService.findJobById(id)
            .map(mapper::map)
            .map(CommonResponseHelper::constructSuccessResponse)
            .subscribeOn(Schedulers.elastic());
    }
}
