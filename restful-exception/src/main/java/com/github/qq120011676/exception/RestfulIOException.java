package com.github.qq120011676.exception;

import java.io.IOException;
import java.text.MessageFormat;

public class RestfulIOException extends IOException implements Restful {
    private Integer httpStatus;
    private String code;
    private String message;

    public RestfulIOException(String code, String message) {
        this(null, code, message);
    }

    public RestfulIOException(Integer httpStatus, String code, String message) {
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
