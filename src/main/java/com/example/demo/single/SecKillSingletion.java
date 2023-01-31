package com.example.demo.single;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.bean.utils.RedisUtil;
import com.example.demo.bean.utils.SpringContextUtils;
import com.example.demo.entity.SecKillEntity;
import com.example.demo.entity.dto.SecKillDto;
import com.example.demo.mapper.SecKillMapper;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecKillSingletion {


    private static volatile SecKillSingletion instance;
    private static SecKillMapper secKillMapper;
    private static RedisUtil redisUtil;

    private SecKillSingletion() {
        secKillMapper = SpringContextUtils.getBean(SecKillMapper.class);
        redisUtil = SpringContextUtils.getBean(RedisUtil.class);
    }

    public static SecKillSingletion getInstance() {
        if (null == instance) {
            synchronized (SecKillSingletion.class) {
                if (null == instance) {
                    instance = new SecKillSingletion();
                }
            }
        }
        return instance;
    }

    /**
     * spinlock
     * @param secKillDto secKillDto
     */
    public Boolean spinlock(SecKillDto secKillDto) {

        int times = 0;

        while (times < 5) {

            times++;
            SecKillEntity secKillEntity = secKillMapper.selectById(secKillDto.getId());
            Integer beforeStock = secKillEntity.getStock();
            int afterStock = beforeStock - secKillDto.getCount();
            if (afterStock < 0) return false;
            secKillEntity.setStock(afterStock);

            LambdaQueryWrapper<SecKillEntity> queryWrapper =
                    new LambdaQueryWrapper<>(SecKillEntity.class)
                            .eq(SecKillEntity::getId, secKillEntity.getId())
                            .eq(SecKillEntity::getVersion, secKillEntity.getVersion())
                            .ge(SecKillEntity::getStock, secKillDto.getCount());

            if (1 == secKillMapper.update(secKillEntity, queryWrapper)) {
                log.info("id:{}, count:{}, beforeStock:{}, afterStock:{}, version:{}", secKillEntity.getId(), secKillDto.getCount(), beforeStock, afterStock, secKillEntity.getVersion());
                return true;
            }
        }

        return false;
    }

    /**
     * byRedis
     * @param secKillDto secKillDto
     */
    public Boolean byRedis(SecKillDto secKillDto) throws InterruptedException {

        String id = secKillDto.getId();

        if (!redisUtil.hasKey(id)) {
            SecKillEntity secKillEntity = secKillMapper.selectById(id);
            synchronized (SecKillSingletion.class) {
                if (!redisUtil.hasKey(id)) {
                    if (redisUtil.incrLock(id)) {
                        Preconditions.checkArgument(redisUtil.set(id, secKillEntity.getStock()));
                    } else {
                        Thread.sleep(1000L);
                    }
                }
            }
        }

        // TODO:

        return null;
    }

}
