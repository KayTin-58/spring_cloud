package com.example.demo.demo.filter;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * description
 *
 * @author zb 2019/04/23 21:11
 */
@Slf4j
@SuppressWarnings("all")
@Component
public class TimeFilter implements Filter {

    /**
     * @param filterConfig
     * @throws
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter init !");
    }

    /**
     * 核心业务逻辑
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("filter doFilter !");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    /**
     *
     */
    @Override
    public void destroy() {
        log.info("filter destroy !");
    }



}
