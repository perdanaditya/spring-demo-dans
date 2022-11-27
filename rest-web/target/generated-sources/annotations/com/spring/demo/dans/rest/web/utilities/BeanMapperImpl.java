package com.spring.demo.dans.rest.web.utilities;

import com.spring.demo.dans.entity.dto.Job;
import com.spring.demo.dans.rest.web.response.JobResponse;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-11-28T00:10:29+0700",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.11 (Oracle Corporation)"
)
public class BeanMapperImpl implements BeanMapper {

    @Override
    public JobResponse map(Job job) {
        if ( job == null ) {
            return null;
        }

        JobResponse jobResponse = new JobResponse();

        jobResponse.setId( job.getId() );
        jobResponse.setType( job.getType() );
        jobResponse.setUrl( job.getUrl() );
        jobResponse.setCreatedAt( job.getCreatedAt() );
        jobResponse.setCompany( job.getCompany() );
        jobResponse.setCompanyUrl( job.getCompanyUrl() );
        jobResponse.setLocation( job.getLocation() );
        jobResponse.setTitle( job.getTitle() );
        jobResponse.setDescription( job.getDescription() );
        jobResponse.setHowToApply( job.getHowToApply() );
        jobResponse.setCompanyLogo( job.getCompanyLogo() );

        return jobResponse;
    }
}
