package com.itchina.seckill;

/**
 * @Date: 2021/3/28 17:12
 * @Desc: 商品秒杀服务
 */
public interface SeckillService {

    GoodsSeckillBO processSeckill(Integer id,String userId,Integer num) throws Exception;
}
