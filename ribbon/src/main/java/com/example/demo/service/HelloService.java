package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 直到世界尽头 on 2018/5/3.
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

//    public String hiService(String name) {
//        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
//    }


 @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }

}
