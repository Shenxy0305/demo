package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

@Data
@TableName("secKill")
public class SecKillEntity {
    @TableId("id")
    private String id;
    @TableField("stock")
    private Integer stock;
    @Version
    @TableField("version")
    private Long version;
}
