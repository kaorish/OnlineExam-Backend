package com.sunhao.onlineexambackend.util;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 处理数据完整性约束异常（如重复主键）
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultUtil handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        String message = "数据完整性约束错误：" + ex.getMostSpecificCause().getMessage();
        return ResultUtil.isFail(400, message);
    }

    // 处理其他异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultUtil handleException(Exception ex) {
        String message = "服务器内部错误：" + ex.getMessage();
        return ResultUtil.isFail(500, message);
    }
}
