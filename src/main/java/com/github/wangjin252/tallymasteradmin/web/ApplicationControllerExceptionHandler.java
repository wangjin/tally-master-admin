package com.github.wangjin252.tallymasteradmin.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常记录
 *
 * @author WangJin
 * @version 1.0
 * @date 2018-08-09 10:07
 */
@ControllerAdvice
public class ApplicationControllerExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = Exception.class)
    public void defaultExceptionHandler(HttpServletRequest request, Exception e) {
        logger.error("处理请求抛出异常，请求URL：{}，", request.getRequestURL().toString(), e);
    }
}
