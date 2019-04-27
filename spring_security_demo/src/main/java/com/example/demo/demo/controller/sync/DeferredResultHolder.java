package com.example.demo.demo.controller.sync;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * description
 *
 * @author zb 2019/04/24 0:44
 */
@Component
public class DeferredResultHolder {

    Map<String, DeferredResult<String>> map = new ConcurrentHashMap<>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }
}
