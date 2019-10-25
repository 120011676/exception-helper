package com.github.qq120011676.conntroller;

import com.github.qq120011676.date.autoconfigure.RequestDateFormatProperties;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestControllerAdvice
public class ControllerAdviceDate {
    @Resource
    private RequestDateFormatProperties requestDateFormatProperties;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(requestDateFormatProperties.getPattern());
        dateFormat.setLenient(requestDateFormatProperties.isLenient());
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, requestDateFormatProperties.isAllowEmpty()));
    }
}
