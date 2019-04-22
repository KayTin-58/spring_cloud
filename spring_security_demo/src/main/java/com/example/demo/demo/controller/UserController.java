package com.example.demo.demo.controller;

import com.example.demo.domain.dto.User;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author zb 2019/04/22 20:44
 */
@RestController
@Slf4j
@RequestMapping(value = "user")
public class UserController {

    @GetMapping
    @JsonView(User.UserSampleView.class)
    public List<User> getUserList(@RequestParam(value = "username", required = false) String username) {
        log.info(username);
        List<User> list = new ArrayList<>();
        list.add(new User());
        return list;

    }


    @GetMapping("/{id}")
    @JsonView(User.UserDetailView.class)
    public User getUser(@PathVariable("id") Long id) {
        log.info("id= {}", id);
        User user = new User();
        return user;

    }
}
