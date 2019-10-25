package com.github.qq120011676.ladybird.web.exception.autoconfigure;

import com.github.qq120011676.ladybird.web.exception.RestfulExceptionHelper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@EnableConfigurationProperties(RestfulExceptionProperties.class)
public class RestFulExceptionAutoConfiguration {
    @Resource
    private RestfulExceptionHelper restfulExceptionHelper;

    @Bean
    @ConditionalOnMissingBean(RestfulExceptionHelper.class)
    public RestfulExceptionHelper restfulExceptionHelper() {
        return this.restfulExceptionHelper;
    }
}
