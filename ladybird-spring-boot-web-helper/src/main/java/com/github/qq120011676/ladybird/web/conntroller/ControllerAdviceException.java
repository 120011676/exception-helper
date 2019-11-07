package com.github.qq120011676.ladybird.web.conntroller;

import com.github.qq120011676.ladybird.web.exception.Restful;
import com.github.qq120011676.ladybird.web.exception.autoconfigure.RestfulExceptionProperties;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdviceException {
    @Resource
    private RestfulExceptionProperties restfulExceptionProperties;

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception e) {
        e.printStackTrace();
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
        } else if (e instanceof BindException) {
            code = "parameter_error";
            StringBuilder message = new StringBuilder();
            BindException bindException = (BindException) e;
            List<ObjectError> objectErrors = bindException.getAllErrors();
            List<Map<String, String>> data = new ArrayList<>(objectErrors.size());
            for (int i = 0; i < objectErrors.size(); i++) {
                ObjectError objectError = objectErrors.get(i);
                Map<String, String> map = new HashMap<>(2);
                if (i > 0) {
                    message.append(System.lineSeparator());
                }
                message.append(objectError.getDefaultMessage());
                map.put("message", objectError.getDefaultMessage());
                Object[] objects = objectError.getArguments();
                if (objects != null) {
                    StringBuilder field = new StringBuilder();
                    for (int j = 0; j < objects.length; j++) {
                        Object object = objects[j];
                        if (object instanceof MessageSourceResolvable) {
                            MessageSourceResolvable messageSourceResolvable = (MessageSourceResolvable) object;
                            if (j > 0) {
                                field.append(",");
                            }
                            field.append(messageSourceResolvable.getDefaultMessage());
                        }
                    }
                    map.put("field", field.toString());
                }
                data.add(map);
            }
            body.put("data", data);
            body.put(this.restfulExceptionProperties.getMessageName(), message);
        } else if (e instanceof AccessDeniedException) {
            code = "no_authority";
            body.put(this.restfulExceptionProperties.getMessageName(), this.restfulExceptionProperties.getMessages().get(code));
        }
        body.put(this.restfulExceptionProperties.getCodeName(), code);
        return new ResponseEntity<>(body, HttpStatus.valueOf(httpStatus));
    }
}
