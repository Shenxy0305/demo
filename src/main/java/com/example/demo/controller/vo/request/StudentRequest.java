package com.example.demo.controller.vo.request;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StudentRequest {

    @Data
    public static class addRequest {
        @NotBlank(message = "未填写姓名!")
        private String name;
        @NotNull(message = "未填写年龄!")
        private Integer age;
        @NotBlank(message = "未填写性别!")
        private String sex;
    }

}
