package com.example;

import com.example.pojo.DataSourceBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		DataSourceBean dataSourceBean = new DataSourceBean();
		SpringApplication.run(EurekaServerApplication.class, args);
	}
}
