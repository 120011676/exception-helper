package com.github.qq120011676.ladybird.web.exception;

import java.text.MessageFormat;

public class RestfulRuntimeException extends RuntimeException implements Restful {
    private Integer httpStatus;
    private String code;
    private String message;

    public RestfulRuntimeException(String code, String message) {
        this(null, code, message);
    }

    public RestfulRuntimeException(Integer httpStatus, String code, String message) {
        super(MessageFormat.format("httpStatus:{0}, code:{1}, message:{2}", httpStatus, code, message));
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
