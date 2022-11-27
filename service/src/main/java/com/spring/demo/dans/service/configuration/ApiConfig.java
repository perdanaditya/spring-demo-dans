package com.spring.demo.dans.service.configuration;

import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClient;
import org.asynchttpclient.DefaultAsyncHttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Rizky Perdana
 */
@Component
public class ApiConfig {

    @Bean
    public AsyncHttpClient asyncHttpClient() {
        DefaultAsyncHttpClientConfig.Builder defaultConfigBuilder =
            new DefaultAsyncHttpClientConfig.Builder().setConnectTimeout(5000)
                .setRequestTimeout(15000);

        defaultConfigBuilder.setUseInsecureTrustManager(true);
        return new DefaultAsyncHttpClient(defaultConfigBuilder.build());
    }
}
