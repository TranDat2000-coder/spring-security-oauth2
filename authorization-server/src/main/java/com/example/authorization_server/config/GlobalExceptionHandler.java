package com.example.authorization_server.config;

import com.example.authorization_server.exception.BusinessException;
import com.example.authorization_server.response.ResponseData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<?> handleBusinessException(BusinessException e) {
        return defHandler(HttpStatus.NOT_ACCEPTABLE, e.getErrorCode(),  e.getMessage());
    }

    public ResponseEntity<Object> defHandler(HttpStatus status, String errorCode, String message){
        return new ResponseEntity<>(ResponseData.failed(status, errorCode, message), status);
    }
}
