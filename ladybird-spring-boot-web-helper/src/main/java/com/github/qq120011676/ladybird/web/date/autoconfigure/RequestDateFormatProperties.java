package com.github.qq120011676.ladybird.web.date.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "ladybird.request-date")
public class RequestDateFormatProperties {
    /**
     * 解析Date时间格式
     */
    private String datePattern = "yyyy-MM-dd HH:mm:ss z";

    /**
     * 解析Date时间时区
     */
    private String dateTimeZone = "GMT+8";

    /**
     * Date是否严格解析时间 false则严格解析 true宽松解析
     */
    private boolean dateLenient = true;

    /**
     * Date是否允许空字符串(false不允许 true允许)
     */
    private boolean dateAllowEmpty = true;

    /**
     * Date自动匹配长度
     */
    private boolean datePatternLengthAuto = true;

    /**
     * 解析LocalDate时间格式
     */
    private String localDatePattern = "yyyy-MM-dd";

    /**
     * 解析LocalDate时间时区
     */
    private String localDateTimeZone = "GMT+8";

    /**
     * LocalDate是否严格解析时间 false则严格解析 true宽松解析
     */
    private boolean localDateLenient = true;

    /**
     * LocalDate是否允许空字符串(false不允许 true允许)
     */
    private boolean localDateAllowEmpty = true;

    /**
     * LocalDate自动匹配长度
     */
    private boolean localDatePatternLengthAuto = true;

    /**
     * 解析LocalDateTime时间格式
     */
    private String localDateTimePattern = "yyyy-MM-dd HH:mm:ss z";

    /**
     * 解析LocalDateTime时间时区
     */
    private String localDateTimeTimeZone = "GMT+8";

    /**
     * LocalDateTime是否严格解析时间 false则严格解析 true宽松解析
     */
    private boolean localDateTimeLenient = true;

    /**
     * LocalDateTime是否允许空字符串(false不允许 true允许)
     */
    private boolean localDateTimeAllowEmpty = true;

    /**
     * LocalDateTime自动匹配长度
     */
    private boolean localDateTimePatternLengthAuto = true;

    /**
     * 解析Date时间格式
     */
    private String localTimePattern = "HH:mm:ss";

    /**
     * 解析LocalTime时间时区
     */
    private String localTimeTimeZone = "GMT+8";

    /**
     * LocalTime是否严格解析时间 false则严格解析 true宽松解析
     */
    private boolean localTimeLenient = true;

    /**
     * LocalTime是否允许空字符串(false不允许 true允许)
     */
    private boolean localTimeAllowEmpty = true;

    /**
     * LocalTime自动匹配长度
     */
    private boolean localTimePatternLengthAuto = true;

}
