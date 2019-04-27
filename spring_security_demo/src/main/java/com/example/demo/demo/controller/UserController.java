package com.example.demo.demo.controller;

import com.example.demo.domain.dto.User;
import com.example.demo.exception.GeneralPurposeException;
import com.example.demo.reponse.ResponseUtils;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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


    @GetMapping("/user/{id}")
    @JsonView(User.UserDetailView.class)
    public User getUser(@PathVariable("id") Long id) {
        log.info("id= {}", id);
        User user = new User();
        return user;

    }

    /**
     * RequestBody 映射json字符串
     *
     * @param user
     * @return
     */
    @PostMapping
    public User postUser(@Valid @RequestBody User user, BindingResult errors) {
        log.info("user:= {}", user.toString());
        if (errors != null) {
            errors.getAllErrors().stream().forEach(x -> log.error("error:={}", x));
        }
        return null;
    }

    /**
     * 更新操作
     *
     * @param user
     * @return
     */
    @PutMapping
    public User putUser(@Valid @RequestBody User user) {
        return user;
    }


    @GetMapping(value = "error")
    public User exception() {
        throw new GeneralPurposeException("user is not exist!");
    }


    @GetMapping(value = "user-list")
    public ResponseEntity getUserList() {
        log.info("进入getUserList");
        List userList = new ArrayList<User>();
        userList.add(new User());
        return ResponseUtils.success(userList);
    }
}
