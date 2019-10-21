package com.github.qq120011676.exception;

public class RestfulRuntimeException extends RestfulException {
    public RestfulRuntimeException(String code, String message) {
        super(code, message);
    }

    public RestfulRuntimeException(int httpStatus, String code, String message) {
        super(httpStatus, code, message);
    }
}
