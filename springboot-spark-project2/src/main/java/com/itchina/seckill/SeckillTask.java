package com.itchina.seckill;

import com.itchina.mapper.GoodsSeckillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Date: 2021/3/28 20:06
 * @Desc:
 */
@Component
public class SeckillTask {
    @Autowired
    private GoodsSeckillMapper goodsSeckillMapper;
    @Autowired
    private RedisTemplate redisTemplate;
    //@Scheduled(cron = "0/5 * * * * ?")
    public void startSeckill() {
        try {
            List<GoodsSeckillBO> list = goodsSeckillMapper.findUnStartSeckillGoods();
            /**
             * 清空redis中的缓存商品
             *
             * */
            redisTemplate.delete("seckill_count_" + "*");
            if (!CollectionUtils.isEmpty(list)) {
                for (GoodsSeckillBO goodsSeckillBO : list) {
                    System.out.println("goodsId= " + goodsSeckillBO.getGoodsId() + ", 开始秒杀活动");
                    /**
                     * 加载进缓存,向右推入数据
                     * ：每个商品，随影redis中的一个队列
                     * */
                    for (int i = 0; i < goodsSeckillBO.getGoodsCount(); i++) {
                        redisTemplate.opsForList().rightPush("seckill_count_" + goodsSeckillBO.getId(), goodsSeckillBO.getGoodsId());
                    }
                    goodsSeckillBO.setStatus(1);
                    goodsSeckillMapper.updateStatus(goodsSeckillBO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
/*
    @Scheduled(cron = "0/5 * * * * ?")
    public void endSeckill() {
        try {
            List<GoodsSeckillBO> list = goodsSeckillMapper.findExpireSeckillGoods();


            if (!CollectionUtils.isEmpty(list)) {
                for (GoodsSeckillBO goodsSeckillBO : list) {
                    System.out.println("id= " + goodsSeckillBO.getId() + ",秒杀活动结束");
                    goodsSeckillBO.setStatus(2);
                    goodsSeckillMapper.updateStatus(goodsSeckillBO);
                    redisTemplate.delete("seckill_count_"+goodsSeckillBO.getId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
