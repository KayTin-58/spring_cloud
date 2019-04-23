package com.example.demo.demo.exchandle;

import com.example.demo.exception.GeneralPurposeException;
import com.example.demo.reponse.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * description:统一异常处理
 *
 * @author zb 2019/04/23 20:51
 */
@ControllerAdvice
@Slf4j
public class UniteExceptionHandler {

    @ExceptionHandler(GeneralPurposeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity exceptionHandle(GeneralPurposeException e) {
        log.info("e:={}", e.toString());
        return ResponseUtils.error(e);
    }
}
