package com.py.tooth.core.config;

import com.py.tooth.core.basic.ErrorInfo;
import com.py.tooth.core.basic.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author czt
 * @description TODO
 * @date 2022/6/27 20:18
 */
@ControllerAdvice
@Slf4j
public class ExceptionConfig {

    @ExceptionHandler(value = Exception.class)
    public Result exceptionHandler(Exception e){
        log.info("controller  error  happened : ",e);
        return Result.fail(ErrorInfo.UNKNOW_ERROR);
    }
}