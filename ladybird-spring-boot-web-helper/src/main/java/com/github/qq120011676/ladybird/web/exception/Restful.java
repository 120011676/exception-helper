package com.github.qq120011676.ladybird.web.exception;

public interface Restful {
    Integer getHttpStatus();

    String getCode();

    String getMessage();
}
