package com.example.demo.bean.utils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public Boolean incrLock(String key) {
        Preconditions.checkNotNull(key);
        Long increment = redisTemplate.opsForValue().increment(key);
        redisTemplate.opsForValue().getAndExpire(key, 1L, TimeUnit.SECONDS);
        return Objects.equals(increment, 1L);
    }

    public Long incr(String key, long delta) {
        Preconditions.checkNotNull(key);
        return redisTemplate.opsForValue().increment(key, delta);
    }

    public Boolean hasKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    public Boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
