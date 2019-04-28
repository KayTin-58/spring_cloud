package com.example.bro.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author zb 2019/04/27 18:30
 */
@RestController
@RequestMapping(value = "test")
public class TestController {

    @GetMapping(value = "get")
    public String get() {
        return "hello security!";
    }
}
