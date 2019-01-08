package com.example.demo.config;

import feign.Retryer;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 直到世界尽头 on 2018/7/29.
 */
@Configuration
public class MyFeignConfig extends FeignClientsConfiguration {


    @Bean
    public Retryer feignRetryer() {
        return super.feignRetryer();
    }



}
