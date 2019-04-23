package com.example.demo.demo.config;

import com.example.demo.demo.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;



/**
 * description
 *
 * @author zb 2019/04/23 21:42
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

   @Autowired
   TimeInterceptor timeInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }

    @Bean
    public FilterRegistrationBean getFilterRegistration() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
       /* filterRegistration.setFilter(new UserPasswordFilter());*/
        return filterRegistration;
    }
}
