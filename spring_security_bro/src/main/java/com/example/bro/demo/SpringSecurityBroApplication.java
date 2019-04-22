package com.example.bro.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringSecurityBroApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityBroApplication.class, args);
    }

}
