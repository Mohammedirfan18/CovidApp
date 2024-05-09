package com.irfan.CovidApp.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestConfigurations {
    @Bean
    public RestTemplate getInstance()
    {
        return new RestTemplate();
    }
}
