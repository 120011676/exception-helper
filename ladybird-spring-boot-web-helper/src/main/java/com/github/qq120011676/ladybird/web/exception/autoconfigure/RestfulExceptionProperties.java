package com.github.qq120011676.ladybird.web.exception.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Data
@ConfigurationProperties(prefix = "ladybird.restful-exception")
public class RestfulExceptionProperties {
    private String codeName = "code";
    private String messageName = "message";
    private int defaultHttpStatus = 400;
    private String defaultCode = "unknown";
    private Map<String, Message> messages;

    @Data
    public static class Message {
        private Integer httpStatus;
        private String message;
    }
}
