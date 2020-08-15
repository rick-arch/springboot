package com.example.springboot.controller;

import com.example.springboot.common.JsonResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.springboot.constant.Constant.ERROR_STACK;

@RestControllerAdvice
@Slf4j
public final class ErrorController {

    @ExceptionHandler(Exception.class)
    public JsonResponseVO exception(Exception e) {
        log.error(ERROR_STACK, e);
        return new JsonResponseVO().setSuccess(Boolean.FALSE).setMsg(e.getMessage());
    }
}
