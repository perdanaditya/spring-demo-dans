package com.spring.demo.dans.service.outbound;

import java.util.Objects;
import java.util.concurrent.ExecutionException;
import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

/**
 * @author Rizky Perdana
 */
@Slf4j
@Service
public class JobRecruitmentOutboundService {

    @Autowired
    private AsyncHttpClient asyncHttpClient;

    public String getJobRecruitment(String path) {
        Response response = null;
        try {
            response = asyncHttpClient
                .prepareGet(
                    "http://dev3.dansmultipro.co.id/api/recruitment" + path)//TODO: taruh properties
                .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .setRequestTimeout(100000)//TODO: taruh properties
                .execute()
                .get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("[getJobRecruitment]", e);
            return null;
        }
        if (Objects.isNull(response.getResponseBody()) || "{}".equals(response.getResponseBody())) {
            return null;
        }
        return response.getResponseBody();
    }
}
