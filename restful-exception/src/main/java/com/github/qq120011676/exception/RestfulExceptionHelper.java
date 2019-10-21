package com.github.qq120011676.exception;

import com.github.qq120011676.exception.autoconfigure.RestfulExceptionProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RestfulExceptionHelper {
    @Resource
    private RestfulExceptionProperties restfulExceptionProperties;

    public RestfulException get(String code) {
        RestfulExceptionProperties.Message message = this.restfulExceptionProperties.getMessages().get(code);
        return new RestfulException(message.getHttpStatus(), code, message.getMessage());
    }
}
