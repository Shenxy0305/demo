package com.example.demo.controller.vo.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SecKillRequest {

    @Data
    public static class Request {
        @NotBlank(message = "id不能为空!")
        private String id;
        @NotNull(message = "count不能为空!")
        private Integer count;
    }
}
