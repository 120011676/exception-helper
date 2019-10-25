package com.github.qq120011676.ladybird.web.conntroller;

import com.github.qq120011676.ladybird.web.date.autoconfigure.RequestDateFormatProperties;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.TimeZone;

@RestControllerAdvice
public class ControllerAdviceDate {
    @Resource
    private RequestDateFormatProperties requestDateFormatProperties;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(this.requestDateFormatProperties.getDatePattern());
        dateFormat.setLenient(this.requestDateFormatProperties.isDateLenient());
        dateFormat.setTimeZone(TimeZone.getTimeZone(this.requestDateFormatProperties.getDateTimeZone()));
        binder.registerCustomEditor(Date.class, this.customDateEditor(this.requestDateFormatProperties.getDatePattern(), this.requestDateFormatProperties.getDateTimeZone(), this.requestDateFormatProperties.isDateLenient(), this.requestDateFormatProperties.isDateAllowEmpty(), this.requestDateFormatProperties.isDatePatternLengthAuto()));
        binder.registerCustomEditor(LocalDate.class, this.customDateEditor(this.requestDateFormatProperties.getLocalDatePattern(), this.requestDateFormatProperties.getLocalDateTimeZone(), this.requestDateFormatProperties.isLocalDateLenient(), this.requestDateFormatProperties.isLocalDateAllowEmpty(), this.requestDateFormatProperties.isLocalDatePatternLengthAuto()));
        binder.registerCustomEditor(LocalDateTime.class, this.customDateEditor(this.requestDateFormatProperties.getLocalDateTimePattern(), this.requestDateFormatProperties.getLocalDateTimeTimeZone(), this.requestDateFormatProperties.isLocalDateTimeLenient(), this.requestDateFormatProperties.isLocalDateTimeAllowEmpty(), this.requestDateFormatProperties.isLocalDateTimePatternLengthAuto()));
        binder.registerCustomEditor(LocalTime.class, this.customDateEditor(this.requestDateFormatProperties.getLocalTimePattern(), this.requestDateFormatProperties.getLocalTimeTimeZone(), this.requestDateFormatProperties.isLocalTimeLenient(), this.requestDateFormatProperties.isLocalTimeAllowEmpty(), this.requestDateFormatProperties.isLocalTimePatternLengthAuto()));
    }

    private CustomDateEditor customDateEditor(String pattern, String timeZone, boolean lenient, boolean allowEmpty, boolean autoLength) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        dateFormat.setLenient(lenient);
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));
        return new CustomDateEditor(dateFormat, allowEmpty) {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                if (autoLength && StringUtils.hasText(text) && text.length() != pattern.length()) {
                    try {
                        super.setValue(new SimpleDateFormat(pattern.substring(0, text.length())).parse(text));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    return;
                }
                super.setAsText(text);
            }
        };
    }
}
