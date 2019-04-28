package com.example.bro.demo.config;


import com.sun.org.apache.regexp.internal.RE;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * description:Security 适配器
 *
 * @author zb 2019/04/27 18:14
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 密码加密解密的类
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        //表单登陆
        http.formLogin()
                .loginPage("/login.html")
                .and()
                .authorizeRequests()
                .antMatchers("/login.html").permitAll()
                .anyRequest()
                .authenticated();

    }
}
