package com.github.qq120011676.exception.conntroller;

import com.github.qq120011676.exception.RestfulException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdviceException {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception e) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", e.getMessage());
        String code = "-1";
        if (e instanceof RestfulException) {
            RestfulException restfulException = (RestfulException) e;
            code = restfulException.getCode();
        }
        body.put("code", code);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
