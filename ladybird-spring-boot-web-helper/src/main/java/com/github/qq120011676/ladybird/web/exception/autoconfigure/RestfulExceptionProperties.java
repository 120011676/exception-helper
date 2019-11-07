package com.github.qq120011676.ladybird.web.exception.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

@Data
@ConfigurationProperties(prefix = "ladybird.restful-exception")
public class RestfulExceptionProperties {
    /**
     * 返回code字段名称
     */
    private String codeName = "code";

    /**
     * 返回message字段名称
     */
    private String messageName = "message";

    /**
     * 默认http状态值
     */
    private int defaultHttpStatus = 400;

    /**
     * 默认code值
     */
    private String defaultCode = "unknown";

    /**
     * 配置异常信息
     */
    private Map<String, Message> messages = new HashMap<>();

    @Data
    public static class Message {
        /**
         * 异常信息返回的http状态（可选）
         */
        private Integer httpStatus;

        /**
         * 异常信息返回的message信息（必须）
         */
        private String message;
    }
}
