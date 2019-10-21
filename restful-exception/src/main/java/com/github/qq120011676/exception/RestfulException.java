package com.github.qq120011676.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.text.MessageFormat;

@EqualsAndHashCode(callSuper = true)
@Data
public class RestfulException extends Exception {
    private Integer httpStatus;
    private String code;
    private String message;

    public RestfulException(String code, String message) {
        this(null, code, message);
    }

    public RestfulException(Integer httpStatus, String code, String message) {
        super(MessageFormat.format("httpStatus:{0}, code:{1}, message:{2}", httpStatus, code, message));
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
