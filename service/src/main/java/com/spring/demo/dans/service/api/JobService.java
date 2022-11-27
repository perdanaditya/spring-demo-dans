package com.spring.demo.dans.service.api;

import com.spring.demo.dans.entity.dto.JobDto;
import java.util.UUID;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Rizky Perdana
 */
public interface JobService {

    Flux<JobDto> findAllJob();
    Mono<JobDto> findJobById(UUID id);
}
