package com.github.qq120011676.exception;

public class RestfulRuntimeException extends RestfulException {
    public RestfulRuntimeException(String code, String message) {
        super(code, message);
    }

    public RestfulRuntimeException(int httpCode, String code, String message) {
        super(httpCode, code, message);
    }
}
