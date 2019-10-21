package com.github.qq120011676.exception.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(RestfulExceptionProperties.class)
public class RestFulExceptionAutoConfiguration {
}
