package com.example.demo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.SecKillEntity;
import com.example.demo.entity.dto.SecKillDto;
import com.example.demo.mapper.SecKillMapper;
import com.example.demo.single.SecKillSingletion;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SecKillTest implements Runnable{

    private static final String ID = "79218496-c60c-4b3e-a96f-09a1169eb174";

    @Override
    public void run() {
        int count = (int) ((Math.random() * 10) + 1);
        SecKillDto secKillDto = SecKillDto.builder().id(ID).count(count).build();
        Boolean result = SecKillSingletion.getInstance().spinlock(secKillDto);
    }

    @Test
    public void start() throws InterruptedException {
        SecKillTest secKillTest = new SecKillTest();
        for(int i = 0; i < 100; i++) {
            Thread t = new Thread(secKillTest);
            t.start();
        }
        Thread.sleep(1000);
    }
}
