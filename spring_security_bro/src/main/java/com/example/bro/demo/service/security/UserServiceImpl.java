package com.example.bro.demo.service.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * description:security
 * 实现security内部的UserDetailsService接口，实现loadUserByUsername方法
 *
 * 补充内容：
 *   需要搞清楚UserDetails接口里面方法的意义
 *
 * @author zb 2019/04/28 21:00
 */
@Component
@Slf4j
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    /**
     * 根据用户名查询用户的详细信息
     * @param username 用户名
     * @return  用户的详细信息
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登陆的用户名：{},密码：{}",username,passwordEncoder.encode("1234"));
        //三个参数解释：用户名 用户密码 用户的权限集合
        return new User(username,passwordEncoder.encode("1234"),
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
