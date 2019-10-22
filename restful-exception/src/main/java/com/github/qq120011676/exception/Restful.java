package com.github.qq120011676.exception;

public interface Restful {
    Integer getHttpStatus();

    String getCode();

    String getMessage();
}
