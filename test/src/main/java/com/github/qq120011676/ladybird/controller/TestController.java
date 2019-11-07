package com.github.qq120011676.ladybird.controller;

import com.github.qq120011676.ladybird.entity.TestEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping
    public String test(@Valid TestEntity test) {
        System.out.println(test);
        return "success";
    }
}
