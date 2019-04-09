package com.example.config;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author zb 2019/04/09 21:38
 */

@Component
@Configuration
@ConfigurationProperties(prefix = "data.source")
public class DataSourceProperties {
    private String url;
    private String userName;


    public DataSourceProperties() {
        System.out.println("DataSourceProperties 被加载了！！！");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
