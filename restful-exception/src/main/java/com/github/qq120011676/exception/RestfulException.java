package com.github.qq120011676.exception;

import lombok.Data;

import java.text.MessageFormat;

@Data
public class RestfulException extends Exception {
    private static int HTTP_CODE_DEFAULT = 500;
    private int httpCode = HTTP_CODE_DEFAULT;
    private String code;
    private String message;

    public RestfulException(String code, String message) {
        super(MessageFormat.format("500:{1}:{2}", HTTP_CODE_DEFAULT, code, message));
        this.code = code;
        this.message = message;
    }

    public RestfulException(int httpCode, String code, String message) {
        super(MessageFormat.format("{0}:{1}:{2}", httpCode, code, message));
        this.httpCode = httpCode;
        this.code = code;
        this.message = message;
    }
}
