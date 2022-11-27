package com.spring.demo.dans.service.impl;

import com.spring.demo.dans.entity.dto.JobDto;
import com.spring.demo.dans.entity.enums.ResponseCode;
import com.spring.demo.dans.libraries.exception.BusinessLogicException;
import com.spring.demo.dans.libraries.helper.JSONHelper;
import com.spring.demo.dans.service.api.JobService;
import com.spring.demo.dans.service.outbound.JobRecruitmentOutboundService;
import java.util.Arrays;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Rizky Perdana
 */
@Slf4j
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobRecruitmentOutboundService jobRecruitmentOutboundService;

    @Override
    public Flux<JobDto> findAllJob() {
        return Mono.justOrEmpty(jobRecruitmentOutboundService.getJobRecruitment("/positions.json"))
            .map(response -> JSONHelper.convertJsonInStringToObject(response, JobDto[].class))
            .switchIfEmpty(Mono.error(new BusinessLogicException(
                ResponseCode.DATA_NOT_EXIST.getCode(),
                ResponseCode.DATA_NOT_EXIST.getMessage())))
            .flatMapIterable(Arrays::asList);
    }

    @Override
    public Mono<JobDto> findJobById(UUID id) {
        return Mono.justOrEmpty(jobRecruitmentOutboundService.getJobRecruitment("/positions/"+id.toString()))
            .map(response -> JSONHelper.convertJsonInStringToObject(response, JobDto.class))
            .switchIfEmpty(Mono.error(new BusinessLogicException(
                ResponseCode.DATA_NOT_EXIST.getCode(),
                ResponseCode.DATA_NOT_EXIST.getMessage())));
    }
}
