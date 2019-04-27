package com.example.demo.demo.controller.sync;

import com.example.demo.demo.domian.OrderQueue;
import com.example.demo.reponse.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import java.util.concurrent.Callable;

/**
 * description
 *
 * @author zb 2019/04/24 0:20
 */
@Slf4j
@RestController
@RequestMapping(value = "sync")
public class SyncController {

    @Autowired
    private OrderQueue orderQueue;
    @Autowired
    private DeferredResultHolder holder;


    @GetMapping
    public String get() throws InterruptedException {
        log.info("主线程开始！");
        Thread.sleep(4000);
        log.info("主线程结束！");
        return "success";
    }

    @GetMapping(value = "sync-test")
    public String getSync() throws InterruptedException {
        log.info("主线程开始！");
        /**
         * 将会发现 这里实际时另外开了一个线程 主线程不会被阻塞
         */
        Callable<String> stringCallable = () -> {
            log.info("fu线程开始！");
            Thread.sleep(4000);
            log.info("fu线程结束！");
            return "sucess";
        };
        log.info("主线程结束！");
        return stringCallable.toString();
    }

    @GetMapping(value = "sync-test-01")
    public ResponseEntity getSync01() throws InterruptedException {
        log.info("主线程开始！");
        String orderNum = RandomStringUtils.randomNumeric(8);
        orderQueue.setOrderNum(orderNum);

        //这句是关键
        DeferredResult deferredResult = new DeferredResult();
        holder.getMap().put(orderNum, deferredResult);
        log.info("主线程结束！");
        return ResponseUtils.success(deferredResult);
    }
}
