package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.entity.SecKillEntity;
import com.example.demo.entity.dto.SecKillDto;
import com.example.demo.entity.dto.StudentDto;
import com.example.demo.utils.result.Result;

public interface ISecKillService extends IService<SecKillEntity> {

    Result<?> spinlock(SecKillDto secKillDto);

}
