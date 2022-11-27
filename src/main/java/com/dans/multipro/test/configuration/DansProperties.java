package com.dans.multipro.test.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Rizky Perdana
 */

@Configuration
@Data
@ConfigurationProperties(value = "dans")
public class DansProperties {

    private String baseUrl;

}
