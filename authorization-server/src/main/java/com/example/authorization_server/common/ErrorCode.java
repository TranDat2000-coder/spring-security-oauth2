package com.example.authorization_server.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorCode {

    SUCCESS("00", "Success"),
    ;

    private String errorCode;

    private String message;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
