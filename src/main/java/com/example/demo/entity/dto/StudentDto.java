package com.example.demo.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {
    private String id;
    private String name;
    private Integer age;
    private Integer sex;
}
