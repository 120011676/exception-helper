package com.github.qq120011676.ladybird.web.date.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "ladybird.request-date")
public class RequestDateFormatProperties {
    /**
     * 解析时间格式
     */
    private String pattern = "yyyy-MM-dd HH:mm:ss";

    /**
     * 是否严格解析时间 false则严格解析 true宽松解析
     */
    private boolean lenient = true;

    /**
     * 解析时间时区
     */
    private String timeZone = "GMT+8";

    /**
     * 是否允许空字符串
     */
    private boolean allowEmpty = true;
}
