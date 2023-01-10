package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("student")
public class StudentEntity {
    @TableField("id")
    private String id;
    @TableField("name")
    private String name;
    @TableField("age")
    private Integer age;
    @TableField("sex")
    private Integer sex;
}
