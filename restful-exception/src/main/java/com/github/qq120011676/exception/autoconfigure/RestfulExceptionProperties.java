package com.github.qq120011676.exception.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "restful-exception")
public class RestfulExceptionProperties {
    private String codeName = "code";
    private String messageName = "message";
    private int defaultHttpStatus = 400;
    private String defaultCode = "-1";
}
