package com.example.demo.entity.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SecKillDto {
    private String id;
    private Integer count;
    private Long version;
}
