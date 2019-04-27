package com.example.demo.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * description:配置切面
 *
 * @author zb 2019/04/23 23:46
 */
@Slf4j
@Component
@Aspect
public class WebAspect {

    /**
     * 环绕通知：
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Around("execution(* com.example.demo.demo.controller..*.*(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("- - - - - 环绕通知 - - - -");
        System.out.println();
        log.info("环绕通知的目标方法名：" + proceedingJoinPoint.getSignature().getName());
        try {
            //obj之前可以写目标方法执行前的逻辑
            //调用执行目标方法
            Object obj = proceedingJoinPoint.proceed();
            return obj;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            log.info("- - - - - 环绕通知 end - - - -");
        }
        return null;
    }

}
