package com.example.authorization_server.exception;

import com.example.authorization_server.common.ErrorCode;
import lombok.Getter;
import lombok.Setter;

public class BusinessException extends RuntimeException {

    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode.getErrorCode();
    }

    public String getMessage() {
        return this.errorCode.getMessage();
    }
}
