package com.example.demo.demo.domian;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * description
 *
 * @author zb 2019/04/24 0:38
 */
@Slf4j
@Component
public class OrderQueue {

    private String orderNum;
    private boolean flag;

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) throws InterruptedException {
        new Thread(() -> {
            log.info("接到下单请求:={}",orderNum);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.flag = true;
            log.info("下单完成：={}",orderNum);
        }).start();


    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}
