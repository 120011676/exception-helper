package com.github.qq120011676.exception;

public class RuntimeExceptionHelper extends ExceptionHelper {
    public RuntimeExceptionHelper(String code, String message) {
        super(code, message);
    }

    public RuntimeExceptionHelper(int httpCode, String code, String message) {
        super(httpCode, code, message);
    }
}
