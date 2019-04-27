package com.example.demo.demo.config;

import com.example.demo.demo.filter.TimeFilter;
import com.example.demo.demo.interceptor.TimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;



/**
 * description:注册配置
 *
 * @author zb 2019/04/23 21:42
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

   @Autowired
   TimeInterceptor timeInterceptor;
   @Autowired
    TimeFilter timeFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeInterceptor);
    }


    /**
     * 正对使用异步的Controller 注册拦截器
     * @param configurer
     */
    @Override
    protected void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        super.configureAsyncSupport(configurer);
    }

    @Bean
    public FilterRegistrationBean getFilterRegistration() {
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        filterRegistration.setFilter(timeFilter);
        return filterRegistration;
    }
}
