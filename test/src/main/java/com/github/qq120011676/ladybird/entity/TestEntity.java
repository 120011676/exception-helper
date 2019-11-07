package com.github.qq120011676.ladybird.entity;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class TestEntity {
    @NotBlank(message = "标题不能为空")
    @Size(max = 20, message = "标题字数超限")
    private String name;

    @NotBlank(message = "email不能为空")
    @Email
    private String email;

    @NotBlank(message = "内容不能为空")
    @Size(max = 1000, message = "内容字数超限")
    private String content;
}
