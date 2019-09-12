package com.qc.advice;

import com.qc.common.Response;
import com.qc.common.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import static com.qc.common.ServiceException.*;

/**
 * @author cys
 * @date 2019/9/5
 * 异常通知类
 */
@Slf4j
@Order(-1)
//拦截异常并统一处理注解
@RestControllerAdvice
public class ControllerResponseAdvice {

    public Response<?> handleException(Exception e) {
        ServiceException se = null;

        if(e instanceof NoHandlerFoundException) {
            se = wrapServiceException(e.getMessage(), NOT_EXIST, e);
        } else if(e instanceof HttpRequestMethodNotSupportedException) {
            se = wrapServiceException(e.getMessage(), NOT_IMPLEMENTED, e);
        } else {
            se = wrapServiceException(GENERAL_EXCEPTION, e);
        }

        logServiceException(log, se.getMessage(), se);

        return new Response<>(se);
    }
}
