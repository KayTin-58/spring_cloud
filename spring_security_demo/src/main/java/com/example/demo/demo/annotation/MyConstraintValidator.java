package com.example.demo.demo.annotation;

import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * description:注解执行器（注解解释器）
 *
 * @author zb 2019/04/23 14:32
 */
@Slf4j
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    /**
     * 初始化时执行
     * @param constraintAnnotation
     */
    @Override
    public void initialize(MyConstraint constraintAnnotation) {

    }

    /**
     * 真正的验证逻辑 验证通过返回 true 否则返回 false
     * @param object  被注解的值
     * @param constraintValidatorContext 上下文
     * @return
     */
    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        log.info("注解对象的值：={}",object);
        //constraintValidatorContext.
        log.info("class:= {}",object.getClass());
        return false;
    }
}
