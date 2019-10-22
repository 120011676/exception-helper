package com.github.qq120011676.exception.conntroller;

import com.github.qq120011676.exception.Restful;
import com.github.qq120011676.exception.autoconfigure.RestfulExceptionProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdviceException {
    @Resource
    private RestfulExceptionProperties restfulExceptionProperties;

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception e) {
        Map<String, Object> body = new HashMap<>();
        body.put(this.restfulExceptionProperties.getMessageName(), e.getMessage());
        String code = this.restfulExceptionProperties.getDefaultCode();
        int httpStatus = this.restfulExceptionProperties.getDefaultHttpStatus();
        if (e instanceof Restful) {
            Restful restful = (Restful) e;
            code = restful.getCode();
            if (!StringUtils.isEmpty(restful.getHttpStatus())) {
                httpStatus = restful.getHttpStatus();
            }
        }
        body.put(this.restfulExceptionProperties.getCodeName(), code);
        return new ResponseEntity<>(body, HttpStatus.valueOf(httpStatus));
    }
}
