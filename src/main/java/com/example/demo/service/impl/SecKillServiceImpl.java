package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.SecKillEntity;
import com.example.demo.entity.dto.SecKillDto;
import com.example.demo.mapper.SecKillMapper;
import com.example.demo.service.ISecKillService;
import com.example.demo.single.SecKillSingletion;
import com.example.demo.http.utils.result.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SecKillServiceImpl extends ServiceImpl<SecKillMapper, SecKillEntity> implements ISecKillService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<?> spinlock(SecKillDto secKillDto) {
        SecKillSingletion secKillSingletion = SecKillSingletion.getInstance();
        return secKillSingletion.spinlock(secKillDto) ? Result.success("下单成功!", secKillDto.getCount()) : Result.fail("下单失败!", secKillDto.getCount());
    }
}
