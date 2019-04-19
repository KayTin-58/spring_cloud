package com.example.demo.controller;

import com.example.demo.annotation.WebDesc;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop1")
public class AopController {

    @RequestMapping("/test")
    public String testAop(String key){
        return "key="+key;
    }

    @RequestMapping("/testAfterThrowing")
    public String testAfterThrowing(String key){
        throw new NullPointerException();
    }

    @RequestMapping("/testAround")
    public String testAround(String key){
        return "key="+key;
    }


    @RequestMapping("/testAnnotation")
    @WebDesc(describe = "This is testAnnotation Controller")
    public String testAnnotation(String key){
        return "key="+key;
    }
}
