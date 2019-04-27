package com.example.demo.demo.listener;

import com.example.demo.demo.controller.sync.DeferredResultHolder;
import com.example.demo.demo.domian.OrderQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author zb 2019/04/25 16:22
 */
@Component
@Slf4j
public class QueueListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private OrderQueue orderQueue;
    @Autowired
    private DeferredResultHolder holder;

    /**
     * 当spring 容器启动的时候会做的事情
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        new Thread(() -> {
            while (true) {
                if(orderQueue.getFlag()){
                    String key = orderQueue.getOrderNum();
                    log.info("the orderNum is:={}",key);
                    holder.getMap().get(key).setResult("task is over !");
                }else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        orderQueue.setFlag(false);
                    }
                }
            }
        }).start();
    }
}
