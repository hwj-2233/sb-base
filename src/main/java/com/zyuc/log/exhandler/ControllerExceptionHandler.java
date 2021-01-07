package com.zyuc.log.exhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author hongwj
 * @date 2021/01/07
 **/
@ControllerAdvice
@ResponseBody
@Slf4j
public class ControllerExceptionHandler {


    /**
     * 处理全部异常
     */
    @ExceptionHandler(Exception.class)
    public String handleException(Exception ex) {
        log.info("程序异常：" + ex.getMessage());
        return "异常";
    }

}
